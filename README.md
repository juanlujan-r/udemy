\# 🎒 RPG Inventory System (Java)



\*\*\[English]\*\*

A robust inventory system for an RPG game aimed at practicing advanced Java concepts like \*\*Generics\*\*, \*\*Abstract Classes\*\*, and \*\*Interfaces\*\*.



The system allows creating specific backpacks (e.g., a Weapons-only backpack or a Potions-only backpack) ensuring type safety at compile time.



\*\*Key Concepts:\*\*

\* \*\*Generics (`<T>`):\*\* Used in the `Backpack` class to restrict content types.

\* \*\*Bounded Type Parameters:\*\* `Backpack<T extends Item \& Usable>` ensures only usable game items can be stored.

\* \*\*Abstraction:\*\* `Item` class defines common properties (name, weight).

\* \*\*Interfaces:\*\* `Usable` contract ensures items have a specific behavior when used.



---



\*\*\[Español]\*\*

Un sistema de inventario robusto para un juego RPG, diseñado para practicar conceptos avanzados de Java como \*\*Genéricos\*\*, \*\*Clases Abstractas\*\* e \*\*Interfaces\*\*.



El sistema permite crear mochilas específicas (ej. una mochila solo para Armas o una solo para Pociones) asegurando la seguridad de tipos (type safety) en tiempo de compilación.



\*\*Conceptos Clave:\*\*

\* \*\*Genéricos (`<T>`):\*\* Usados en la clase `Backpack` para restringir los tipos de contenido.

\* \*\*Parámetros de Tipo Acotados:\*\* `Backpack<T extends Item \& Usable>` asegura que solo se guarden ítems del juego que sean usables.

\* \*\*Abstracción:\*\* La clase `Item` define propiedades comunes (nombre, peso).

\* \*\*Interfaces:\*\* El contrato `Usable` garantiza que los ítems tengan un comportamiento específico al usarse.



\## 📂 Project Structure / Estructura del Proyecto



\* `Item` (Abstract Class): Base entity.

\* `Usable` (Interface): Defines the `use()` method.

\* `Weapon` / `Potion`: Concrete implementations.

\* `Backpack<T>`: The generic container.

\* `Main`: Entry point to test the logic.



\## 🚀 How to Run / Cómo Ejecutar



1\.  Clone the repository / Clona el repositorio.

2\.  Navigate to the folder / Navega a la carpeta:

&nbsp;   ```bash

&nbsp;   cd Java/InventarioJuego

&nbsp;   ```

3\.  Compile and run / Compila y ejecuta:

&nbsp;   ```bash

&nbsp;   javac Main.java

&nbsp;   java Main

&nbsp;   ```



---

\*Created by \[Juan Lujan](https://github.com/juanlujan-r)\*

