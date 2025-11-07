package co.edu.uniquindio.SOLID.Model.Strategy;

import co.edu.uniquindio.SOLID.Model.Pedido;

public interface EstrategiaDescuento {
    String getcodigo();
    double calcularDescuento(double subtotal, Pedido pedido);
    boolean esAplicable(Pedido pedido);
}
