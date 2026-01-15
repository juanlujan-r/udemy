package org.jvalencia.datastructures;

public class Queue { // (FIFO) Primero en entrar, primero en salir
    private int maxSize;
    private int[] queueArray;
    private int front; // Puntero al primer elemento (el que va a salir)
    private int rear;  // Puntero al último elemento (el que acaba de entrar)
    private int nItems; // Contador de cuántos elementos hay

    // Constructor
    public Queue(int size) {
        this.maxSize = size;
        this.queueArray = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;
    }

    // Insertar al final de la cola (Enqueue)
    public void insert(int value) {
        if (isFull()) {
            System.out.println("Cola llena.");
            return;
        }
        // Lógica circular: si llegamos al final del arreglo, volvemos al inicio (0)
        if (rear == maxSize - 1) {
            rear = -1;
        }
        rear++; // Movemos el puntero del final
        queueArray[rear] = value; // Insertamos el dato
        nItems++; // Aumentamos el contador de items
    }

    // Quitar del frente de la cola (Dequeue)
    public int remove() {
        if (isEmpty()) {
            System.out.println("Cola vacía.");
            return -1;
        }
        int temp = queueArray[front]; // Guardamos el dato del frente
        front++; // El siguiente pasa a ser el frente
        // Lógica circular: si el frente se pasa del arreglo, vuelve a 0
        if (front == maxSize) {
            front = 0;
        }
        nItems--; // Disminuimos el contador
        return temp;
    }

    // Ver el frente
    public int peekFront() {
        return queueArray[front];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }
}
