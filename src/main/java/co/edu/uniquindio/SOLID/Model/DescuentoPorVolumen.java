package co.edu.uniquindio.SOLID.Model;

import co.edu.uniquindio.SOLID.Model.Strategy.EstrategiaDescuento;
import co.edu.uniquindio.SOLID.Service.PedidoService;

public class DescuentoPorVolumen implements EstrategiaDescuento {
    private String codigo;
    private double cantidadMinima;
    private double porcentaje;

    public DescuentoPorVolumen(String codigo, double cantidadMinima, double porcentaje) {
        this.codigo = codigo;
        this.cantidadMinima = cantidadMinima;
        this.porcentaje = porcentaje;
    }

    @Override
    public double calcularDescuento(double subtotal, Pedido pedido) {
        return subtotal * (this.porcentaje/ 100.0);
    }

    public boolean esAplicable(Pedido pedido) {
        PedidoService pedidoService = PedidoService.getInstance();
        if(pedidoService.Totalitems(pedido) > this.cantidadMinima) {
            return true;
        };

        return false;
    }

    public String getcodigo() {return codigo;}


}
