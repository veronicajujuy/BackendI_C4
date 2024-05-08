package dh.backend.service;

import dh.backend.model.Producto;
import dh.backend.model.Tarjeta;

public interface IFacadeDescuento {
    int calculoDescuento(Tarjeta tarjeta, Producto producto, int cantidad);
}
