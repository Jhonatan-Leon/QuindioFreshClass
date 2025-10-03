package co.edu.uniquindio.SOLID.Service;

import co.edu.uniquindio.SOLID.Model.Minimercado;
import co.edu.uniquindio.SOLID.Model.Producto;

public class CatalogoProductosService {
    
    public void agregarProducto(Producto producto) {

        Minimercado.getInstancia().addProducto(producto);
    }

    public Producto buscarProducto(String sku) {
        for (Producto producto : Minimercado.getInstancia().getProductos()) {
            if (producto.getSku().equalsIgnoreCase(sku)) {
                return producto;
            }
        }
        return null;
    }

    public void mostrarCatalogo() {
        System.out.println("Catálogo de Productos:");
        for (Producto producto : CatalogoProductos.getInstancia().getProductos()) {
            System.out.println(producto);
        }
    }
}
