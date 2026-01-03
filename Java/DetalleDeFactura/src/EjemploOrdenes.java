public class EjemploOrdenes {
    public static void main(String[] args) {
        OrdenCompra orden1 = new OrdenCompra("Compras Tecnologicas");
        orden1.setCliente(new Cliente("Pablo", "Neruda"));
        orden1.addProducto(new Producto("Televisor","Toshiba",3000000));
        orden1.addProducto(new Producto("Barra de Sonido","Samsung",565000));
        orden1.addProducto(new Producto("Computador de Mesa","Dell",5400000));
        orden1.addProducto(new Producto("Pantalla","LG",850000));

        OrdenCompra orden2 = new OrdenCompra("Compras Sexuales");
        orden2.setCliente(new Cliente("Geraldin", "Gutierrez"));
        orden2.addProducto(new Producto("Super Consolador", "Golosas Extremas", 1500000));
        orden2.addProducto(new Producto("Super Plug Anal", "Guia Cereza", 250000));
        orden2.addProducto(new Producto("Super Vibrador Pro", "Satisfier", 700000));
        orden2.addProducto(new Producto("Super Succionador Anal", "Negrotes Calientes", 30000));

        OrdenCompra orden3 = new OrdenCompra("Comida para navidad");
        orden3.setCliente(new Cliente("Juanito","Alimana"));
        orden3.addProducto(new Producto("Leche","Colanta", 4000));
        orden3.addProducto(new Producto("Queso","Montefrio", 12000));
        orden3.addProducto(new Producto("Lecherita","Betania", 8000));
        orden3.addProducto(new Producto("Harina de Arepas","P.A.N", 10000));

        OrdenCompra orden4 = new OrdenCompra("Cosas de Perros");
        orden4.setCliente(new Cliente("Pepito","Perez"));
        orden4.addProducto(new Producto("Pelota","Kong", 26000));
        orden4.addProducto(new Producto("Cama","Laika", 250000));
        orden4.addProducto(new Producto("Bolsas","X", 4000));
        orden4.addProducto(new Producto("Concentrado","Vivance", 180000));

        OrdenCompra[] ordenes = {orden1, orden2, orden3, orden4};
        for (OrdenCompra orden : ordenes){
            System.out.println("________________________________");
            System.out.println("ID de orden: " + orden.getIdentificador());
            System.out.println("Descripcion: " + orden.getDescripcion());
            System.out.println("Cliente: " + orden.getCliente().getNombre() + " " + orden.getCliente().getApellido());
            System.out.println("Fecha: " + orden.getFecha());
            for (Producto p : orden.getProductos()){
                System.out.println("* " + p.getNombre() + " / " + p.getFabricante() + " -----> " + String.format("$ %,d", p.getPrecio()));
            }
            System.out.println("Total: $" + String.format("%,d",orden.getGranTotal()));

        }
    }
}
