import java.util.Scanner;

public class Mayor2Num {
    static void main(String[] args) {
        int n1, n2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el primer número");
        n1 = scanner.nextInt();
        System.out.println("Ingrese el segundo número");
        n2 = scanner.nextInt();
        System.out.println(n1 > n2 ? n1 + "\n" + n2 : n2 + "\n" + n1);
    }
}
