import java.util.Scanner;

public class CapacidadGasolina {
    public static void main(String[] args) {
        double cTotal = 70, cActual = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad actual de gasolina");
        cActual = scanner.nextDouble();
        while (cActual > 70 || cActual < 0){
            System.out.println("El valor ingresado es invalido");
            System.out.println("Ingrese la cantidad actual de gasolina");
            cActual = scanner.nextDouble();
        }
        if (cActual == 70) {
            System.out.println("Estanque lleno");
        } else if (cActual < 70 && cActual >= 60){
            System.out.println("Estanque casi lleno");
        } else if (cActual < 60 && cActual > 39){
            System.out.println("Estanque 3/4");
        } else if (cActual < 40 && cActual > 34){
            System.out.println("Medio Estanque");
        } else if (cActual < 35 && cActual > 19){
            System.out.println("Suficiente");
        } else if (cActual < 21 && cActual > 0){
            System.out.println("Insufiente");
        }
    }
}
