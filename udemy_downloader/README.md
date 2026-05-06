# Udemy Course Downloader

Script Python para descargar videos de tus cursos comprados en Udemy usando la API interna del sitio.

## ¿Cómo funciona?

Udemy expone una API interna (`/api-2.0/`) que usa su propia web. Este script se autentica con tu **access_token** de sesión y consulta esa API para:

1. Listar tus cursos comprados
2. Obtener la estructura de capítulos y clases
3. Descargar los archivos MP4 disponibles

> **Sobre DRM**: Udemy usa cifrado **Widevine** en muchos de sus cursos pagos. Si una clase está protegida con DRM, este script **no puede descargarla** (ni ninguna otra herramienta que no tenga una clave de descifrado). El script reportará estas clases como `[DRM]` en la consola.

---

## Requisitos

- Python 3.10 o superior
- pip

---

## Instalación

```bash
# Clonar el repo (o solo copiar la carpeta udemy_downloader/)
git clone https://github.com/juanlujan-r/udemy.git
cd udemy/udemy_downloader

# Instalar dependencias
pip install -r requirements.txt
```

---

## Cómo obtener tu `access_token`

1. Abrí **Chrome** o **Firefox** y andá a [https://www.udemy.com](https://www.udemy.com)
2. Logueate con tu cuenta
3. Abrí **DevTools** con `F12`
4. Andá a la pestaña **Application** (Chrome) o **Storage** (Firefox)
5. En el panel izquierdo: **Cookies → https://www.udemy.com**
6. Buscá la cookie llamada **`access_token`**
7. Copiá su valor (es una cadena larga, como un JWT)

> El token expira periódicamente. Si obtenés error 401, repetí este proceso.

---

## Uso

### Modo interactivo (listar cursos y elegir)

```bash
python downloader.py --token "TU_ACCESS_TOKEN"
```

Te mostrará la lista de cursos y te preguntará cuál descargar.

### Descargar un curso específico por ID

Podés encontrar el ID en la URL del curso: `udemy.com/course/nombre-del-curso/` → buscalo en la API o en la lista interactiva.

```bash
python downloader.py --token "TU_TOKEN" --course-id 12345
```

### Descargar todos los cursos

```bash
python downloader.py --token "TU_TOKEN" --all
```

### Cambiar carpeta de destino

```bash
python downloader.py --token "TU_TOKEN" --output "D:\Cursos Udemy"
```

### Preferir una calidad específica

```bash
# Máxima calidad disponible (default)
python downloader.py --token "TU_TOKEN" --quality 0

# Máximo 720p
python downloader.py --token "TU_TOKEN" --quality 720
```

---

## Estructura de archivos generada

```
udemy_courses/
└── Nombre del Curso/
    ├── 01 - Introduccion/
    │   ├── 001 - Bienvenida.mp4
    │   └── 002 - Configuracion del entorno.mp4
    ├── 02 - Fundamentos/
    │   ├── 003 - Variables y tipos.mp4
    │   └── 004 - Funciones.mp4
    └── ...
```

---

## Salida de consola

```
============================================================
Curso : Complete Python Bootcamp
ID    : 567890
Destino: udemy_courses/Complete Python Bootcamp
============================================================

  [01] Getting Started
    [1080] 001 - Introduction.mp4
    [SKIP] 002 - Setup.mp4          ← ya existía
    [DRM ] 003 - Resources          ← protegido con Widevine

  [02] Python Basics
    [ 720] 004 - Variables.mp4
    [ 720] 005 - Strings.mp4
```

---

## Limitaciones conocidas

| Situación | Qué hace el script |
|---|---|
| Video con DRM (Widevine) | Reporta `[DRM]`, no descarga |
| Stream HLS (`.m3u8`) sin DRM | Reporta `[HLS]`, necesita `ffmpeg` |
| Token expirado | Error 401 con mensaje claro |
| Video ya descargado | `[SKIP]`, no re-descarga |
| Interrupción con Ctrl+C | Muestra resumen parcial |

---

## ¿Por qué no usar el Network Tab del navegador?

Era tu idea original y tiene sentido intuitivo, pero tiene tres problemas fundamentales:

1. **Los videos son streams segmentados** (HLS/DASH): no hay un único archivo, son cientos de fragmentos `.ts` que hay que ensamblar.
2. **Las URLs tienen tokens firmados con expiración corta**: la URL que copiás del Network Tab deja de funcionar en minutos.
3. **DRM**: si el video usa Widevine, el stream está cifrado y sin la clave de descifrado no se puede reproducir fuera del player.

Este script resuelve los puntos 1 y 2 usando la API oficial. El punto 3 no tiene solución técnica accesible.
