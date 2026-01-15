package org.jvlujan.edificio;

import java.util.Scanner;

public class Oficina extends Local{
    private boolean esPremium;


        public Oficina(int piso, int numero, double precioBase, String[] caracteristicas, boolean esPremium){
        super(piso, numero, precioBase, caracteristicas);
        this.esPremium = esPremium;
    }
    @Override
    public double CalcularAlquiler() {
            double alquiler;
        if (esPremium == true) {
           alquiler = precioBase*1.1;
        }else{
            alquiler = precioBase;
        }
        return alquiler;
    }

    @Override
    public String toString() {
            if (esPremium == true) {
                return "[" + piso + "]" + "[" + numero + "] Oficina Premium - Alquiler: " + String.format("%,.0f", CalcularAlquiler());
            }else{
             return "[" + piso + "]" + "[" + numero + "] Oficina Sencilla - Alquiler: " + String.format("%,.0f", CalcularAlquiler()) ;
        }
    }
}
