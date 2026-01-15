package org.jvalencia.almacen;
import org.jvalencia.almacen.persona.*;
public class Almacen {

    static void main(String[] args) {
        Persona p = new Persona("Juan", "Sanchez", "25658", "Avenida Siempre Viva");
        System.out.println("Persona: " + p.toString());
        Cliente c = new Cliente("Juan", "Perez", "123456", "En la casa", 2525);
        System.out.println("Cliente: " + c.toString());
        Gerente g = new Gerente("Marcos", "Perez", "23123", "Casita Azul", 5000000, 123, 500000000);
        System.out.println("Gerente: " + g.toString());
        Empleado e = new Empleado("Marcos", "Perez", "23123", "Casita Azul", 2000000, 125);
        System.out.println("Empleado: " + e.toString());
        e.AumentarRemuneracion(10);
        System.out.println("Empleado: " + e.toString());
    }


}
