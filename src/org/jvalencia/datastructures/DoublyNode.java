package org.jvalencia.datastructures;

public class DoublyNode {
    public int data;
    public DoublyNode next;     // Siguiente nodo
    public DoublyNode previous; // Nodo anterior

    // Constructor
    public DoublyNode(int data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public void displayNode() {
        System.out.print("{" + data + "} ");
    }
}
