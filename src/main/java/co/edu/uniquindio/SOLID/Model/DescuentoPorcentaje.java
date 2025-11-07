package co.edu.uniquindio.SOLID.Model;

import co.edu.uniquindio.SOLID.Model.Strategy.EstrategiaDescuento;

public class DescuentoPorcentaje implements EstrategiaDescuento {
    private double porcentaje;
    private String codigo;

    public DescuentoPorcentaje(String codigo, double porcentaje) {
        this.codigo = codigo;
        this.porcentaje = porcentaje;
    }

    public double calcularDescuento(double subtotal, Pedido pedido) {
        return subtotal * (this.porcentaje/100);
    }

    public boolean esAplicable(Pedido pedido) {
        if(pedido.getCodigo() != null && pedido.getCodigoDescuento().equals(codigo)) {
            return true;
        };
        return false;
    }

    public String getcodigo() {return codigo;}
}
