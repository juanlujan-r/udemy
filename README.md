# \# Java Generics \& Type Safety 🧬

# 

# \*\*(Español)\*\*

# Este repositorio es una demostración técnica de la Programación Genérica en Java.

# El objetivo es mostrar cómo desacoplar la lógica del tipo de dato, permitiendo crear componentes de software reutilizables y seguros en tiempo de compilación.

# 

# \*\*(English)\*\*

# This repository is a technical demonstration of Generic Programming in Java.

# The goal is to showcase how to decouple logic from data types, enabling the creation of reusable and type-safe software components.

# 

# \## 🛠 Modules / Módulos

# 

# \### 1. Generic Wrappers (`GenericBox`)

# Demonstrates how to create a class that can encapsulate any object type while maintaining type safety methods.

# \*Demuestra cómo crear una clase que puede encapsular cualquier objeto manteniendo métodos seguros.\*

# 

# \### 2. Generic Methods (`DataProcessor`)

# Static utility methods that can process arrays of different types without code duplication.

# \*Métodos estáticos de utilidad que pueden procesar arreglos de diferentes tipos sin duplicar código.\*

# \* \*\*Features:\*\*

# &nbsp;   \* Unbounded wildcards / \*Comodines no acotados.\*

# &nbsp;   \* Bounded Type Parameters (`<T extends Comparable>`) for logical comparisons. / \*Parámetros acotados para comparaciones lógicas.\*

# 

# \### 3. Generic Nodes (`GenericNode`)

# Implementation of a node structure capable of holding generic data `<T>`, serving as a base for dynamic data structures.

# \*Implementación de una estructura de nodo capaz de contener datos genéricos, sirviendo como base para estructuras dinámicas.\*

# 

# \## 💻 Usage Example

# 

# ```java

# // Using DataProcessor to find the max of different types

# Integer maxInt = DataProcessor.findMax(10, 50, 20);      // Returns 50

# String maxStr = DataProcessor.findMax("Apple", "Zoo", "Banana"); // Returns "Zoo"

