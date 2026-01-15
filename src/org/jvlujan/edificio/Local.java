package org.jvlujan.edificio;

import java.util.Arrays;
import java.util.function.DoubleToIntFunction;

public abstract class Local {
    protected double precioBase;
    protected int piso, numero;
    protected String[] caracteristicas;

    public Local (int piso, int numero, double precioBase, String[] caracteristicas){
        this.piso = piso;
        this.numero = numero;
        this.precioBase = precioBase;
        this.caracteristicas = caracteristicas;
    }
    static void main(String[] args) {
        Local[][] edificio = new Local[5][4];
        String[] extrasBasicos = {"Agua", "Electricidad"};
        String[] extrasPremium = {"Fibra Optica", "AC"};

        edificio[0][0] = new Comercio(0, 0, 1000000, extrasBasicos, 2.5);
        edificio[0][1] = new Comercio(0, 1, 1500000, extrasBasicos, 3);
        edificio[0][2] = new Comercio(0, 2, 1200000, extrasBasicos, 2);
        edificio[0][3] = new Comercio(0, 3, 900000, extrasBasicos, 10);
        edificio[1][0] = new Oficina(1, 0, 1000000, extrasPremium, true);
        edificio[1][1] = new Oficina(1, 1, 1005000, extrasPremium, true);
        edificio[1][2] = new Oficina(1, 2, 105000, extrasPremium, true);
        edificio[1][3] = new Oficina(1, 3, 100600, extrasPremium, true);
        edificio[2][0] = new Oficina(2, 0, 1000000, extrasBasicos, false);
        edificio[2][1] = new Oficina(2, 1, 9000000, extrasBasicos, false);
        edificio[2][2] = new Oficina(2, 2, 11000000, extrasBasicos, false);
        edificio[2][3] = new Oficina(2, 3, 12000000, extrasBasicos, false);
        edificio[3][0] = new Comercio(3, 0, 10000000, extrasPremium, 10);
        edificio[3][1] = new Comercio(3, 1, 13000000, extrasPremium, 5);
        edificio[3][2] = new Comercio(3, 2, 15000000, extrasPremium, 8);
        edificio[3][3] = new Comercio(3, 3, 2000000, extrasPremium, 6);
        edificio[4][0] = new Oficina(4, 0, 4000000, extrasPremium, true);
        edificio[4][1] = new Oficina(4, 1, 5000000, extrasPremium, false);
        edificio[4][2] = new Oficina(4, 2, 6000000, extrasPremium, false);
        edificio[4][3] = new Oficina(4, 3, 7000000, extrasPremium, true);

        System.out.println("--------Mapa del edificio---------");
        for (int i = 0; i < edificio.length; i++) {
            for (int j = 0; j < edificio[i].length; j++) {
                System.out.println(edificio[i][j].toString());
            }
        }
    }

    public abstract double CalcularAlquiler();

    @Override
    public String toString() {
        return "Local [" + piso + "]" + "[" + numero +  "]\n" +
                "Precio Base = " + precioBase +
                "\nCaracteristicas = " + Arrays.toString(caracteristicas);
    }
}
