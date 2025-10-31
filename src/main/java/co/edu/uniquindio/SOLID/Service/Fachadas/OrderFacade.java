package co.edu.uniquindio.SOLID.Service.Fachadas;

import co.edu.uniquindio.SOLID.Model.DTO.ItemPedidoDTO;
import co.edu.uniquindio.SOLID.Model.DTO.PedidoDTO;
import co.edu.uniquindio.SOLID.Model.DTO.ResumenPedidoDTO;
import co.edu.uniquindio.SOLID.Service.PedidoService;

import java.util.List;

public class OrderFacade {
    private static OrderFacade Instance;
    private final PedidoService pedidoService = PedidoService.getInstance();

    public static OrderFacade getInstance(){
        if(Instance == null){
            Instance = new OrderFacade();
        }
        return Instance;
    }

    public ResumenPedidoDTO processOrder(PedidoDTO pedidoDTO){
        return pedidoService.procesarPedido(pedidoDTO);
    }

    public double calcularTotal(double subtotal, double costoEnvio) {
        return pedidoService.calcularTotal(subtotal, costoEnvio);
    }

    public double calcularSubtotal(List<ItemPedidoDTO> items) {
        return pedidoService.calcularSubtotal(items);
    }

    public double calcularCostoEnvio(String tipoEnvio) {
        return pedidoService.calcularCostoEnvio(tipoEnvio);
    }

    public PedidoService getPedidoService() {
        return pedidoService;
    }

}
