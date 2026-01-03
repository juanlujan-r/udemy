package org.jvalencia.almacen.persona;

public class Persona {
    protected String nombre, apellido, NumeroFiscal, direccion;

    public Persona(String nombre, String apellido, String numeroFiscal, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        NumeroFiscal = numeroFiscal;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNumeroFiscal() {
        return NumeroFiscal;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "Hola soy de la clase Persona\n" +
                "nombre= '" + nombre + '\'' +
                ", apellido= '" + apellido + '\'' +
                ", NumeroFiscal= '" + NumeroFiscal + '\'' +
                ", direccion= '" + direccion + '\'';
    }
}
