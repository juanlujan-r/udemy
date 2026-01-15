package org.jvalencia.datastructures;

public class Node {
    public int data;   // El dato (entero)
    public Node next;  // Referencia al siguiente nodo (conexión)

    // Constructor
    public Node(int data) {
        this.data = data;
        this.next = null; // Por defecto no apunta a nadie
    }

    // Metodo para imprimir el contenido del nodo
    public void displayNode() {
        System.out.print("{" + data + "} ");
    }
}
