package dh.backend.service;

import dh.backend.model.Producto;
import dh.backend.model.Tarjeta;

public class FacadeDescuento implements IFacadeDescuento{

    ApiCantidad apiCantidad;
    ApiTarjeta apiTarjeta;
    ApiProducto apiProducto;

    public FacadeDescuento() {
        apiCantidad = new ApiCantidad();
        apiProducto = new ApiProducto();
        apiTarjeta = new ApiTarjeta();
    }
    @Override
    public int calculoDescuento(Tarjeta tarjeta, Producto producto, int cantidad) {
        int sumaDescuentos = 0;
        sumaDescuentos += apiCantidad.descuento(cantidad);
        sumaDescuentos += apiTarjeta.descuento(tarjeta);
        sumaDescuentos += apiProducto.descuento(producto);
        return sumaDescuentos;
    }
}
