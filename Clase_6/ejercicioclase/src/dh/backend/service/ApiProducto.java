package dh.backend.service;

import dh.backend.model.Producto;

public class ApiProducto {
    public int descuento(Producto producto){
        int descuento = 0;
        if(producto.getTipo().equals("latas")){
            descuento = 10;
        }
        return descuento;
    }
}
