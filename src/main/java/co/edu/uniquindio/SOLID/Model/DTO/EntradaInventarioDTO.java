package co.edu.uniquindio.SOLID.Model.DTO;

import co.edu.uniquindio.SOLID.Model.ItemEntrada;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class EntradaInventarioDTO {
    private String id;
    private LocalDateTime fecha;
    private String nitProveedor;
    private List<ItemEntradaDTO> items;

    public EntradaInventarioDTO (String id, LocalDateTime fecha, String nitProveedor, List<ItemEntradaDTO> items) {
        this.id = id;
        this.fecha = fecha;
        this.nitProveedor = nitProveedor;
        this.items = items;
    }

    public String getId () {return id;}

    public void setId (String id) {this.id = id;}

    public LocalDateTime getFecha  () {return fecha;}

    public void setFecha (LocalDateTime fecha) {this.fecha = fecha;}

    public String getNitProveedor () {return nitProveedor;}

    public void setNitProveedor (String nitProveedor) {this.nitProveedor = nitProveedor;}

    public List<ItemEntradaDTO> getItems () {return items;}

    public void setItems (List<ItemEntradaDTO> items) {this.items = items;}
}
