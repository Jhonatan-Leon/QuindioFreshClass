package co.edu.uniquindio.SOLID.Model;

import co.edu.uniquindio.SOLID.Model.Strategy.EstrategiaDescuento;

public class DescuentoCantidadFija implements EstrategiaDescuento {
    private String codigo;
    private double cantidadFija;

    public DescuentoCantidadFija(String codigo, double cantidadFija) {
        this.codigo = codigo;
        this.cantidadFija = cantidadFija;
    }

    public double calcularDescuento(double precio, Pedido pedido) {
        return Math.min(precio, this.cantidadFija);

    }

    public String getcodigo() {return codigo;}

    public boolean esAplicable(Pedido pedido) {
        if(pedido.getCodigo() != null && pedido.getCodigoDescuento().equals(this.codigo)) {
            return true;
        }
        return false;
    }


}
