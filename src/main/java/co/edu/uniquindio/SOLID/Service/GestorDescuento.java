package co.edu.uniquindio.SOLID.Service;

import co.edu.uniquindio.SOLID.Model.DTO.ResumenPedidoDTO;
import co.edu.uniquindio.SOLID.Model.DescuentoCantidadFija;
import co.edu.uniquindio.SOLID.Model.DescuentoPorVolumen;
import co.edu.uniquindio.SOLID.Model.DescuentoPorcentaje;
import co.edu.uniquindio.SOLID.Model.Pedido;
import co.edu.uniquindio.SOLID.Model.Strategy.EstrategiaDescuento;

import java.util.ArrayList;
import java.util.List;

public class GestorDescuento {
    private List<EstrategiaDescuento> descuento;

    private static GestorDescuento Instance;

    public static GestorDescuento getInstance(){
        if(Instance == null){
            Instance = new GestorDescuento(new DescuentoPorcentaje("DTO10", 10));
        }
        return Instance;
    }

    public GestorDescuento(EstrategiaDescuento descuento) {
        this.descuento = new ArrayList<>();
        initialize();
    }

    public void initialize(){
        descuento.add( new DescuentoPorcentaje( "DTO10", 10));
        descuento.add(new DescuentoPorVolumen( "VOL15 ", 5, 15.0));
        descuento.add(new DescuentoCantidadFija( "DESC5000", 5000.0));
    }

    public EstrategiaDescuento seleccionado (Pedido pedido){
        if(pedido.getCodigo() != null && !pedido.getCodigo().isEmpty()){
            for(EstrategiaDescuento descuento: descuento){
                if(descuento.esAplicable(pedido)){
                    return descuento;
                }
            }
        }
        return null;
    }

    public double aplicarDescuento(double subtotal, Pedido pedido){
        EstrategiaDescuento descuentoSeleccionado = seleccionado(pedido);
        if(descuentoSeleccionado != null){
            return descuentoSeleccionado.calcularDescuento(subtotal, pedido);
        }
        return subtotal;
    }

}
