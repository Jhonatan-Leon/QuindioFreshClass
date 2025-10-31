package co.edu.uniquindio.SOLID.Model.DTO;

public class MovimientoInventarioDTO {

    private String id;
    private String tipo;
    private String fecha;
    private String skuProducto;
    private int cantidad;
    private String referencia;

    public MovimientoInventarioDTO(String id, String tipo, String fecha, String skuProducto, int cantidad, String referencia) {
        this.id = id;
        this.tipo = tipo;
        this.fecha = fecha;
        this.skuProducto = skuProducto;
        this.cantidad = cantidad;
        this.referencia = referencia;
    }

    public String getId() { return id; }
    public String getTipo() { return tipo; }
    public String getFecha() { return fecha; }
    public String getSkuProducto() { return skuProducto; }
    public int getCantidad() { return cantidad; }
    public String getReferencia() { return referencia; }

    public void setId (String id) {
        this.id = id;
    }

    public void setTipo (String tipo) {
        this.tipo = tipo;
    }
    public void setFecha (String fecha) {
        this.fecha = fecha;
    }
    public void setSkuProducto (String skuProducto) {
        this.skuProducto = skuProducto;
    }
    public void setCantidad (int cantidad) {
        this.cantidad = cantidad;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
}
