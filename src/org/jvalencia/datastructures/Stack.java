package org.jvalencia.datastructures;

public class Stack { // Ultimo en entrar, primero en salir (LIFO)
        private int maxSize;    // Tamaño máximo del arreglo
        private int[] stackArray; // El arreglo que guarda los datos
        private int top;        // Índice que apunta al elemento en la cima

        // Constructor: Inicializa la pila con un tamaño específico
        public Stack(int size) {
            this.maxSize = size;
            this.stackArray = new int[maxSize];
            this.top = -1; // -1 indica que la pila está vacía (no hay índice 0 aún)
        }

        // Metodo para agregar un elemento arriba (Push)
        public void push(int value) {
            if (isFull()) {
                System.out.println("La pila está llena. No se puede agregar " + value);
                return;
            }
            top++; // Movemos el puntero hacia arriba
            stackArray[top] = value; // Guardamos el valor en la nueva posición
        }

        // Metodo para sacar el elemento de arriba (Pop)
        public int pop() {
            if (isEmpty()) {
                System.out.println("La pila está vacía.");
                return -1; // Retorno de error indicando vacío
            }
            int oldTop = stackArray[top]; // Guardamos el valor para devolverlo
            top--; // Bajamos el puntero (el dato "lógicamente" se borra)
            return oldTop;
        }

        // Metodo para ver qué hay arriba sin sacarlo (Peek)
        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return stackArray[top];
        }

        // Verifica si la pila está vacía
        public boolean isEmpty() {
            return (top == -1);
        }

        // Verifica si la pila está llena
        public boolean isFull() {
            return (top == maxSize - 1);
        }
    }


