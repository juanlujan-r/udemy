package org.jvalencia.almacen.persona;

public class Empleado extends Persona{
    private double remuneracion;
    private int empleadoId;

    public Empleado(String nombre, String apellido, String numeroFiscal, String direccion, double remuneracion, int empleadoId) {
        super(nombre, apellido, numeroFiscal, direccion);
        this.remuneracion = remuneracion;
        this.empleadoId = empleadoId;
    }

    public void AumentarRemuneracion (float porcentaje){
        this.remuneracion = (this.remuneracion * (1 + (porcentaje/100)));
    }

    public double getRemuneracion() {
        return remuneracion;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSoy de la clase Empleado" +
                "\nremuneracion=" + String.format("%,.0f", remuneracion) +
                ", empleadoId=" + empleadoId;
    }
}
