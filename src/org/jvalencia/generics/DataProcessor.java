package org.jvalencia.generics;

public class DataProcessor {

    // Metodo Genérico: Recibe un array de CUALQUIER tipo (E) y lo imprime
    // E puede ser Integer, String, Double, etc.
    public static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println(); // Salto de línea
    }

    // Metodo Genérico con Bounded Type Parameters (Límites)
    // Solo acepta tipos que sean "Comparables" (como números o strings)
    // para poder determinar cuál es mayor.
    public static <T extends Comparable<T>> T findMax(T x, T y, T z) {
        T max = x; // Asumimos que x es el mayor inicialmente

        if (y.compareTo(max) > 0) {
            max = y; // y es mayor
        }

        if (z.compareTo(max) > 0) {
            max = z; // z es mayor
        }

        return max; // Retorna el mayor de los tres
    }
}