package co.edu.uniquindio.SOLID.Service.Fachadas;

import co.edu.uniquindio.SOLID.Model.DTO.ProductoDTO;
import co.edu.uniquindio.SOLID.Model.DTO.ProveedorDTO;
import co.edu.uniquindio.SOLID.Model.EntradaInventario;
import co.edu.uniquindio.SOLID.Service.InventoryService;

public class InventoryFacade {
    private static InventoryFacade Instance;
    private final InventoryService inventoryService = InventoryService.getInstance();

    public static InventoryFacade getInstance(){
        if(Instance == null){
            Instance = new InventoryFacade();
        }
        return Instance;
    }

    public EntradaInventario registerInventario(ProveedorDTO proveedor, ProductoDTO product, int cantidad){
        return inventoryService.registrarEntradaInventario(proveedor, product, cantidad);
    }
}
