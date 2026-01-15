package org.jvalencia.generics;

// Clase Genérica: Una "Caja" que puede guardar cualquier objeto
public class GenericBox<T> {
    private T content; // El contenido de la caja

    // Metodo para guardar algo en la caja
    public void set(T content) {
        this.content = content;
    }

    // Metodo para sacar lo que hay en la caja
    public T get() {
        return content;
    }

    // Metodo para inspeccionar el tipo de dato que guardamos
    public void inspect() {
        System.out.println("Tipo de dato: " + content.getClass().getName());
        System.out.println("Valor: " + content);
    }
}