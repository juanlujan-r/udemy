#!/usr/bin/env python3
"""
Udemy Course Downloader

Usa la API interna de Udemy con tu token de sesion para descargar
cursos comprados. Descarga MP4 directos cuando estan disponibles;
reporta las clases protegidas con DRM (Widevine) que no pueden
descargarse por este medio.

Instrucciones para obtener el access_token:
    1. Abre udemy.com en Chrome/Firefox y loguéate
    2. Abre DevTools (F12) > Application > Cookies > www.udemy.com
    3. Copia el valor de la cookie 'access_token'
    4. Pásalo con --token "TU_TOKEN"

Requisitos:
    pip install -r requirements.txt

Ejemplos de uso:
    # Listar cursos y elegir cuál descargar:
    python downloader.py --token "TU_TOKEN"

    # Descargar un curso específico por ID:
    python downloader.py --token "TU_TOKEN" --course-id 12345

    # Descargar todos los cursos:
    python downloader.py --token "TU_TOKEN" --all

    # Cambiar carpeta de destino:
    python downloader.py --token "TU_TOKEN" --output "D:/Cursos"

    # Preferir calidad 720p en vez de la máxima:
    python downloader.py --token "TU_TOKEN" --quality 720
"""

import sys
import time
import argparse
import requests
from pathlib import Path
from tqdm import tqdm

BASE_URL = "https://www.udemy.com/api-2.0"
DEFAULT_OUTPUT = "udemy_courses"
DEFAULT_QUALITY = 0  # 0 = máxima disponible
CHUNK_SIZE = 1024 * 256  # 256 KB
REQUEST_DELAY = 0.4  # segundos entre requests para no abusar de la API

# Caracteres no permitidos en nombres de archivos/carpetas en Windows
WIN_INVALID_CHARS = r'\/:*?"<>|'


class UdemyDownloader:
    def __init__(self, access_token: str, output_dir: str, preferred_quality: int):
        self.session = requests.Session()
        self.session.headers.update({
            "Authorization": f"Bearer {access_token}",
            "X-Udemy-Authorization": f"Bearer {access_token}",
            "Content-Type": "application/json",
            "Referer": "https://www.udemy.com/",
            "Origin": "https://www.udemy.com",
        })
        self.output_dir = Path(output_dir)
        self.output_dir.mkdir(parents=True, exist_ok=True)
        self.preferred_quality = preferred_quality
        self.stats = {"downloaded": 0, "skipped": 0, "drm": 0, "error": 0}

    # ------------------------------------------------------------------
    # API helpers
    # ------------------------------------------------------------------

    def _get(self, url: str, params: dict = None) -> dict:
        time.sleep(REQUEST_DELAY)
        resp = self.session.get(url, params=params, timeout=30)
        resp.raise_for_status()
        return resp.json()

    def get_courses(self) -> list:
        """Retorna todos los cursos comprados por el usuario."""
        courses = []
        url = f"{BASE_URL}/users/me/subscribed-courses/"
        params = {
            "page_size": 100,
            "ordering": "-last_accessed",
            "fields[course]": "id,title,url",
        }
        while url:
            data = self._get(url, params)
            courses.extend(data.get("results", []))
            url = data.get("next")
            params = {}
        return courses

    def get_curriculum(self, course_id: int) -> list:
        """Retorna todos los ítems del curriculum de un curso (capítulos + clases)."""
        items = []
        url = f"{BASE_URL}/courses/{course_id}/subscriber-curriculum-items/"
        params = {
            "page_size": 200,
            "fields[lecture]": "title,asset,object_index",
            "fields[asset]": "stream_urls,download_urls,asset_type,length,title",
            "fields[chapter]": "title,object_index",
        }
        while url:
            data = self._get(url, params)
            items.extend(data.get("results", []))
            url = data.get("next")
            params = {}
        return items

    # ------------------------------------------------------------------
    # Video URL resolution
    # ------------------------------------------------------------------

    def _pick_url(self, candidates: list) -> tuple:
        """
        Elige la URL de mejor calidad (o la más cercana a preferred_quality).
        Retorna (url, label) o (None, None) si la lista está vacía.
        """
        if not candidates:
            return None, None

        def quality_key(item):
            try:
                return int(str(item.get("label", "0")).replace("p", ""))
            except ValueError:
                return 0

        if self.preferred_quality == 0:
            best = max(candidates, key=quality_key)
        else:
            # Buscar la calidad exacta o la inmediatamente inferior
            sorted_cands = sorted(candidates, key=quality_key)
            best = sorted_cands[0]
            for c in sorted_cands:
                if quality_key(c) <= self.preferred_quality:
                    best = c

        return best.get("file"), best.get("label", "?")

    def resolve_video_url(self, asset: dict) -> tuple:
        """
        Intenta obtener una URL descargable directa (MP4).
        Retorna (url, quality_label, source_type) donde source_type es
        'download', 'stream', 'hls' o 'drm'.
        """
        # La API puede devolver null en lugar de {} para estos campos
        downloads = (asset.get("download_urls") or {}).get("Video", [])
        if downloads:
            url, label = self._pick_url(downloads)
            if url:
                return url, label, "download"

        streams = (asset.get("stream_urls") or {}).get("Video", [])
        if streams:
            url, label = self._pick_url(streams)
            if url:
                if ".m3u8" in url or "hls" in url.lower():
                    return url, label, "hls"
                return url, label, "stream"

        return None, None, "drm"

    # ------------------------------------------------------------------
    # Descarga de archivos
    # ------------------------------------------------------------------

    def _download_mp4(self, url: str, dest: Path) -> bool:
        """Descarga un MP4 directo con barra de progreso. Retorna True si éxito."""
        dest.parent.mkdir(parents=True, exist_ok=True)
        tmp = dest.with_suffix(".tmp")

        try:
            with self.session.get(url, stream=True, timeout=60) as resp:
                resp.raise_for_status()
                total = int(resp.headers.get("Content-Length", 0))
                with open(tmp, "wb") as f, tqdm(
                    total=total or None,
                    unit="B",
                    unit_scale=True,
                    unit_divisor=1024,
                    desc=f"    {dest.name[:50]}",
                    leave=False,
                ) as bar:
                    for chunk in resp.iter_content(chunk_size=CHUNK_SIZE):
                        f.write(chunk)
                        bar.update(len(chunk))
            tmp.rename(dest)
            return True
        except Exception as exc:
            print(f"    ERROR al descargar: {exc}")
            if tmp.exists():
                tmp.unlink()
            return False

    # ------------------------------------------------------------------
    # Lógica principal de descarga
    # ------------------------------------------------------------------

    def download_course(self, course: dict):
        course_id = course["id"]
        course_title = _safe_name(course.get("title", f"course_{course_id}"))
        course_dir = self.output_dir / course_title
        course_dir.mkdir(parents=True, exist_ok=True)

        print(f"\n{'='*60}")
        print(f"Curso : {course.get('title', course_id)}")
        print(f"ID    : {course_id}")
        print(f"Destino: {course_dir}")
        print("="*60)

        items = self.get_curriculum(course_id)
        chapter_dir = course_dir  # fallback si no hay capítulos
        lecture_counter = 0

        for item in items:
            kind = item.get("_class")

            if kind == "chapter":
                chapter_idx = item.get("object_index", 0)
                chapter_name = _safe_name(
                    f"{chapter_idx:02d} - {item.get('title', 'Capitulo')}"
                )
                chapter_dir = course_dir / chapter_name
                chapter_dir.mkdir(exist_ok=True)
                print(f"\n  [{chapter_idx:02d}] {item.get('title', '')}")

            elif kind == "lecture":
                # La API puede devolver asset=null en lecturas sin video
                asset = item.get("asset") or {}
                asset_type = asset.get("asset_type", "")

                if asset_type != "Video":
                    continue

                lecture_counter += 1
                idx = item.get("object_index", lecture_counter)
                title = _safe_name(f"{idx:03d} - {item.get('title', 'Lectura')}")
                dest = chapter_dir / f"{title}.mp4"

                url, quality, src_type = self.resolve_video_url(asset)

                if dest.exists():
                    print(f"    [SKIP] {title[:55]}")
                    self.stats["skipped"] += 1
                    continue

                if src_type == "drm":
                    print(f"    [DRM ] {title[:55]}  (protegido con Widevine, no descargable)")
                    self.stats["drm"] += 1
                    continue

                if src_type == "hls":
                    print(f"    [HLS ] {title[:55]}  (stream HLS — necesita ffmpeg, ver README)")
                    self.stats["drm"] += 1
                    continue

                print(f"    [{quality:>4}] {title[:55]}")
                ok = self._download_mp4(url, dest)
                if ok:
                    self.stats["downloaded"] += 1
                else:
                    self.stats["error"] += 1

    def print_summary(self):
        print("\n" + "="*60)
        print("RESUMEN")
        print(f"  Descargados : {self.stats['downloaded']}")
        print(f"  Ya existían : {self.stats['skipped']}")
        print(f"  DRM/HLS     : {self.stats['drm']}  (no descargables sin Widevine)")
        print(f"  Errores     : {self.stats['error']}")
        print("="*60)


# ------------------------------------------------------------------
# Utilidades
# ------------------------------------------------------------------

def _safe_name(name: str) -> str:
    """Elimina caracteres inválidos en Windows y trunca a 100 chars."""
    for ch in WIN_INVALID_CHARS:
        name = name.replace(ch, "_")
    return name.strip()[:100]


def pick_course(courses: list) -> list:
    """Muestra la lista de cursos y retorna la selección del usuario."""
    print("\nCursos comprados:")
    for i, c in enumerate(courses, 1):
        print(f"  {i:3}. [{c['id']}] {c['title']}")

    print("\nOpciones:")
    print("  'todos'  — descargar todos")
    print("  número   — descargar ese curso")
    print("  'q'      — salir")

    while True:
        choice = input("\nElegí una opción: ").strip().lower()
        if choice == "q":
            return []
        if choice == "todos":
            return courses
        if choice.isdigit():
            idx = int(choice) - 1
            if 0 <= idx < len(courses):
                return [courses[idx]]
        print("Opción inválida, intentá de nuevo.")


# ------------------------------------------------------------------
# Entry point
# ------------------------------------------------------------------

def main():
    parser = argparse.ArgumentParser(
        description="Descarga cursos de Udemy usando la API interna.",
        formatter_class=argparse.RawDescriptionHelpFormatter,
        epilog=__doc__,
    )
    parser.add_argument(
        "--token", required=True,
        help="Valor de la cookie 'access_token' de www.udemy.com",
    )
    parser.add_argument(
        "--output", default=DEFAULT_OUTPUT,
        help=f"Carpeta de destino (default: {DEFAULT_OUTPUT})",
    )
    parser.add_argument(
        "--course-id", type=int,
        help="ID numérico de un curso específico",
    )
    parser.add_argument(
        "--all", action="store_true",
        help="Descargar todos los cursos sin preguntar",
    )
    parser.add_argument(
        "--quality", type=int, default=DEFAULT_QUALITY,
        help="Calidad preferida en píxeles (ej: 720). 0 = máxima (default)",
    )
    args = parser.parse_args()

    downloader = UdemyDownloader(args.token, args.output, args.quality)

    try:
        if args.course_id:
            course = {"id": args.course_id, "title": f"Curso_{args.course_id}"}
            try:
                info = downloader._get(
                    f"{BASE_URL}/courses/{args.course_id}/",
                    {"fields[course]": "id,title"}
                )
                course["title"] = info.get("title", course["title"])
            except Exception:
                pass
            courses_to_download = [course]
        else:
            print("Obteniendo lista de cursos...")
            courses = downloader.get_courses()
            if not courses:
                print("No se encontraron cursos. Verificá tu token.")
                sys.exit(1)
            print(f"Se encontraron {len(courses)} cursos.")

            if args.all:
                courses_to_download = courses
            else:
                courses_to_download = pick_course(courses)

        if not courses_to_download:
            print("Nada que descargar.")
            sys.exit(0)

        for course in courses_to_download:
            downloader.download_course(course)

        downloader.print_summary()

    except requests.HTTPError as exc:
        status = exc.response.status_code if exc.response is not None else "?"
        if status == 401:
            print("\nERROR 401: Token inválido o expirado.")
            print("Obten un nuevo access_token desde DevTools > Application > Cookies.")
        elif status == 403:
            print("\nERROR 403: Acceso denegado. El token puede estar mal o el curso no es tuyo.")
        else:
            print(f"\nERROR HTTP {status}: {exc}")
        sys.exit(1)
    except KeyboardInterrupt:
        print("\n\nDescarga interrumpida por el usuario.")
        downloader.print_summary()
        sys.exit(0)


if __name__ == "__main__":
    main()
