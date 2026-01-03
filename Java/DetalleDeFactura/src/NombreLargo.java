import javax.swing.*;

public class NombreLargo {
    public static void main(String[] args) {
        String nombre1, nombre2, nombre3, masLargo;
        nombre1 = JOptionPane.showInputDialog("Ingrese el nombre de la primera persona");
        nombre2 = JOptionPane.showInputDialog("Ingrese el nombre de la primera persona");
        nombre3 = JOptionPane.showInputDialog("Ingrese el nombre de la primera persona");
        masLargo = nombre1.length() > nombre2.length() ? nombre1 : nombre2;
        masLargo = masLargo.length() > nombre3.length() ? masLargo : nombre3;
        JOptionPane.showMessageDialog(null, masLargo + " tiene el nombre mas largo");
    }
}
