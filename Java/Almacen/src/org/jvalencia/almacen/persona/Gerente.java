package org.jvalencia.almacen.persona;


import java.util.Scanner;

public class Gerente extends Empleado{
    private Double presupuesto;

    public Gerente(String nombre, String apellido, String numeroFiscal, String direccion, double remuneracion, int empleadoId, double presupuesto) {
        super(nombre, apellido, numeroFiscal, direccion, remuneracion, empleadoId);
        this.presupuesto = presupuesto;
    }

    public Gerente(String nombre, String apellido, String numeroFiscal, String direccion, double remuneracion, int empleadoId) {
        super(nombre, apellido, numeroFiscal, direccion, remuneracion, empleadoId);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el presupuesto");
        presupuesto = scanner.nextDouble();
    }
    
    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Double getPresupuesto() {
        return presupuesto;
    }

    @Override
    public String toString() {
        return "Soy de la clase Gerente\n" +
                "presupuesto= " + String.format("%,.0f", presupuesto);
    }
}
