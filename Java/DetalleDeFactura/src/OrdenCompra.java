import java.util.Date;

public class OrdenCompra {
    private int identificador;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private Producto[] productos;
    private static int ultimoId;
    private int indiceProductos;

    public OrdenCompra(String descripcion){
        this.descripcion = descripcion;
        this.identificador = ++ultimoId;
        this.productos = new Producto[4];
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public void addProducto (Producto producto){
        if (indiceProductos < productos.length){
            this.productos[indiceProductos++] = producto;
        }
    }
    public int getGranTotal(){
        int total = 0;
        for (Producto p : productos) {
            if (p != null){
                total += p.getPrecio();
            }
        }
        return total;
    }
}
