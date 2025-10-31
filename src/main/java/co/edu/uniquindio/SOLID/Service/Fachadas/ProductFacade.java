package co.edu.uniquindio.SOLID.Service.Fachadas;

import co.edu.uniquindio.SOLID.Model.DTO.ProductoDTO;
import co.edu.uniquindio.SOLID.Service.ProductoService;

import java.util.List;

public class ProductFacade {
    private static ProductFacade Instance;
    private final ProductoService ProductoService;
    public static ProductFacade getInstance(){
        if(Instance == null){
            Instance = new ProductFacade();
            return  Instance;
        }
        return Instance;
    }

    private ProductFacade(){
        this.ProductoService = new ProductoService();
    }

    public List<ProductoDTO> getAllProducts() {
        return ProductoService.obtenerTodosLosProductos();
    }

    public ProductoDTO searchProduct(String Sku){
        return ProductoService.buscarProductoPorSku(Sku);
    }

    public boolean adddProduct(ProductoDTO product){
        return ProductoService.agregarProducto(product);
    }

    public boolean updateProduct(ProductoDTO productoDTO){
        return ProductoService.actualizarProducto(productoDTO);
    }

    public boolean deleteProduct(String Sku) {
        return ProductoService.eliminarProducto(Sku);
    }

}
