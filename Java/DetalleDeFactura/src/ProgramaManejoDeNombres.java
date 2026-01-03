import java.util.Scanner;

public class ProgramaManejoDeNombres {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del primer integrante");
        String Integrante1 = scanner.nextLine();
        int l = Integrante1.length();
        String I1 = String.valueOf(Integrante1.charAt(1));
        I1 = (I1.toUpperCase() + "." + Integrante1.substring(l-2));
        System.out.println(I1);
        System.out.println("Ingrese el nombre del segundo integrante");
        String Integrante2 = scanner.nextLine();
        l = Integrante2.length();
        String I2 = String.valueOf(Integrante2.charAt(1));
        I2 = (I2.toUpperCase() + "." + Integrante2.substring(l-2));
        System.out.println(I2);
        System.out.println("Ingrese el nombre del tercer integrante");
        String Integrante3 = scanner.nextLine();
        l = Integrante3.length();
        String I3 = String.valueOf(Integrante3.charAt(1));
        I3 = (I3.toUpperCase() + "." + Integrante3.substring(l-2));
        System.out.println(I3);
        System.out.println(I1 + "_" + I2 + "_" + I3);
    }
}

