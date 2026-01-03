\# 🏢 Skyline Tower Management System



Este proyecto es una simulación de backend en Java para la gestión administrativa de un edificio corporativo de 5 pisos.



El objetivo principal fue aplicar \*\*Lógica de Matrices\*\* combinada con \*\*Programación Orientada a Objetos (POO)\*\* para administrar diferentes tipos de inmuebles (Locales y Oficinas) dentro de una misma estructura de datos.



\## 🚀 Conceptos Técnicos Aplicados



\* \*\*Clases Abstractas:\*\* Implementación de la clase padre `Local` para definir un contrato estricto (`CalcularAlquiler`) que todas las subclases deben cumplir.

\* \*\*Matrices de Objetos (2D Arrays):\*\* Modelado del edificio utilizando una matriz `Local\[5]\[4]` (5 pisos, 4 locales por piso).

\* \*\*Polimorfismo:\*\* Capacidad de almacenar objetos de tipo `Oficina` y `Comercio` dentro de la misma matriz genérica y ejecutar sus métodos específicos en tiempo de ejecución.

\* \*\*Encapsulamiento y Modificadores:\*\* Uso estratégico de `protected` para facilitar la herencia y `private` para proteger la lógica de negocio interna.



\## 🛠️ Arquitectura del Proyecto



El sistema utiliza una jerarquía de herencia para diferenciar el cálculo de la renta:



\### 1. Clase Base: `Local` (Abstracta)

Define las propiedades comunes:

\* Piso y Número.

\* Precio Base.

\* Listado de Características (Array de Strings).



\### 2. Subclases (Hijas)

\* \*\*🏢 Oficina:\*\*

&nbsp;   \* Atributo único: `esPremium` (boolean).

&nbsp;   \* \*\*Lógica de Negocio:\*\* Si es Premium, el alquiler aumenta un \*\*10%\*\* sobre el precio base.

\* \*\*🏪 Comercio:\*\*

&nbsp;   \* Atributo único: `metrosVitrina` (double).

&nbsp;   \* \*\*Lógica de Negocio:\*\* El alquiler suma un recargo de \*\*$50 por cada metro\*\* de vitrina.



\## 📋 Estructura de Archivos

```text

org.jvlujan.edificio

├── Local.java       # Clase Abstracta y Entry Point (Main)

├── Oficina.java     # Lógica para oficinas corporativas

└── Comercio.java    # Lógica para locales comerciales

