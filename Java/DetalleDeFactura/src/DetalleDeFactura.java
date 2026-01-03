import java.text.DecimalFormat;
import java.util.Scanner;

public class DetalleDeFactura {
    public static void main(String[] args) {
        DecimalFormat formatoDinero = new DecimalFormat("COP#,###.00");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la factura");
        String nombreFactura = scanner.nextLine();
        System.out.println("Ingrese el valor del producto 1");
        double producto1 = scanner.nextDouble();
        System.out.println("Ingrese el valor del producto 2");
        double producto2 = scanner.nextDouble();
        double totalNeto, totalBruto;
        totalBruto = producto1 + producto2;
        double iva = totalBruto * 0.19;
        totalNeto = totalBruto - iva;
        System.out.println("La factura "+nombreFactura+" tiene un total bruto de "+formatoDinero.format(totalBruto)+", con un impuesto de "+formatoDinero.format(iva)+" y el monto después de impuesto es de: "+formatoDinero.format(totalNeto));
    }
}
