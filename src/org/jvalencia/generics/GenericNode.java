package org.jvalencia.generics;

// Clase Nodo Genérica: Puede guardar Integer, String, Personas, etc.
public class GenericNode<T> {
    public T data;              // El dato es de tipo T (Genérico)
    public GenericNode<T> next; // Apunta al siguiente nodo del mismo tipo

    public GenericNode(T data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "{" + data + "}";
    }
}