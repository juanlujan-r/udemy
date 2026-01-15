# Dynamic Implementations (Nodes & Generics) ebox

**(Español)**
Esta carpeta contiene versiones alternativas de las Pilas y Colas ubicadas en el paquete principal.
A diferencia de las versiones principales (que usan Arreglos fijos y tipos `int`), estas clases utilizan **Listas Enlazadas (Nodos)** y **Genéricos (`<T>`)**. Esto permite que las estructuras crezcan dinámicamente y almacenen cualquier tipo de dato.

**(English)**
This folder contains alternative versions of the Stacks and Queues found in the main package.
Unlike the main versions (which use fixed Arrays and `int` types), these classes utilize **Linked Lists (Nodes)** and **Generics (`<T>`)**. This allows the structures to grow dynamically and store any data type.

## 📄 File Descriptions / Descripción de Archivos

### `Stack_Nodes.java`
* **Dynamic Sizing:** Does not require a predefined size limit. It grows as new elements are pushed. / *No requiere un límite de tamaño predefinido. Crece a medida que se insertan elementos.*
* **Logic:** Uses a `top` pointer to track the head of the list. / *Usa un puntero `top` para rastrear la cabeza de la lista.*

### `Queue_Nodes.java`
* **Dynamic Sizing:** Infinite capacity (limited only by system memory). / *Capacidad infinita (limitada solo por la memoria del sistema).*
* **Logic:** Maintains pointers to both `head` (front) and `tail` (rear) for O(1) insertion and removal. / *Mantiene punteros a `head` (frente) y `tail` (final) para inserción y eliminación eficientes.*