\# 👥 Corporate Personnel Management System



Este proyecto es una aplicación de consola en Java diseñada para gestionar la jerarquía de personas involucradas en un negocio (Almacén).



El objetivo principal fue implementar \*\*Herencia Multinivel\*\* y \*\*Polimorfismo\*\* para diferenciar entre empleados, gerentes y clientes, manteniendo una base de código limpia y reutilizable.



\## 🚀 Arquitectura del Código (OOP)



El sistema se basa en una superclase genérica `Persona` que extiende sus atributos a roles específicos.



\### Jerarquía de Clases

\* \*\*Persona (Base):\*\* Gestiona datos comunes (Nombre, Apellido, ID Fiscal, Dirección).

&nbsp;   \* \*\*Cliente:\*\* Hereda de Persona y añade `clienteId`.

&nbsp;   \* \*\*Empleado:\*\* Hereda de Persona.

&nbsp;       \* Maneja `remuneracion` (sueldo) y `empleadoId`.

&nbsp;       \* Incluye lógica de negocio para aumentos salariales.

&nbsp;       \* \*\*Gerente:\*\* Hereda de Empleado.

&nbsp;           \* Gestiona un `presupuesto` asignado.

&nbsp;           \* Implementa sobrecarga de constructores (uno de ellos permite entrada de datos manual vía `Scanner`).



\## 💻 Características Técnicas Destacadas



1\.  \*\*Lógica de Negocio Encapsulada:\*\*

&nbsp;   \* Método `AumentarRemuneracion(float porcentaje)`: Permite calcular incrementos salariales dinámicos basados en porcentajes, protegiendo el atributo privado `remuneracion`.



2\.  \*\*Manejo de Tipos de Datos:\*\*

&nbsp;   \* Uso de `String.format("%,.0f")` para la presentación profesional de cifras monetarias en consola.

&nbsp;   \* Casteo implícito y explícito en operaciones matemáticas.



3\.  \*\*Sobreescritura (Override):\*\*

&nbsp;   \* Cada clase implementa su propia versión de `toString()`, reutilizando el código de la clase padre (`super.toString()`) y añadiendo sus datos únicos.



\## 🛠️ Estructura del Proyecto

```text

org.jvalencia.almacen

├── Almacen.java           # Clase Principal (Entry Point)

└── persona                # Paquete de Modelos

&nbsp;   ├── Persona.java       # Clase Padre

&nbsp;   ├── Cliente.java

&nbsp;   ├── Empleado.java

&nbsp;   └── Gerente.java

