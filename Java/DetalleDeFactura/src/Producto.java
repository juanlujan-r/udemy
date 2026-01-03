
public class Producto {
    private String fabricante;
    private String nombre;
    private int precio;

    public Producto (String nombre, String fabricante, int precio){
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.precio = precio;
        }

    public String getFabricante() {
        return fabricante;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
      return precio;
    }
}
