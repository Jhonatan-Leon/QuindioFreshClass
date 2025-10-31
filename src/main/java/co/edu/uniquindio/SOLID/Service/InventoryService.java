package co.edu.uniquindio.SOLID.Service;

import co.edu.uniquindio.SOLID.Model.DTO.ProductoDTO;
import co.edu.uniquindio.SOLID.Model.DTO.ProveedorDTO;
import co.edu.uniquindio.SOLID.Model.EntradaInventario;
import co.edu.uniquindio.SOLID.utils.Mappers.ProveedorMapper;

public class InventoryService {
    static InventoryService Instance;

    public static InventoryService getInstance() {
        if (Instance == null) {
            Instance = new InventoryService();
        }
        return Instance;
    }

    public EntradaInventario registrarEntradaInventario(ProveedorDTO proveedor, ProductoDTO producto, int cantidad) {
        if (proveedor == null) {
            throw new IllegalArgumentException("Se requiere un proveedor");
        }
        if (producto == null) {
            throw new IllegalArgumentException("Se requiere un producto");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        EntradaInventario entrada = new EntradaInventario("ENT-" + System.currentTimeMillis(), ProveedorMapper.toEntity(proveedor));
        entrada.agregarItem(producto, cantidad);
        entrada.confirmar();
        return entrada;
    }
}
