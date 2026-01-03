package org.jvlujan.edificio;

import java.util.Arrays;
import java.util.Scanner;

public class Comercio extends Local{
    double metrosVitrina;

    public Comercio(int piso, int numero, double precioBase, String[] caracteristicas, double metrosVitrina){
        super(piso, numero, precioBase, caracteristicas);
        this.metrosVitrina = metrosVitrina;
    }

    @Override
    public double CalcularAlquiler(){
        double alquiler;
        alquiler = precioBase + (metrosVitrina * 50);
        return alquiler;
    }

    @Override
    public String toString() {
        return "[" + piso + "]" + "[" + numero + "] Comercio -> Metros de vitrina: " + metrosVitrina + "- Alquiler: " + String.format("%,.0f", CalcularAlquiler());
    }
}
