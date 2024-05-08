package dh.backend.service;

import dh.backend.model.Tarjeta;

public class ApiTarjeta {
    public int descuento(Tarjeta tarjeta){
        int descuento = 0;
        if(tarjeta.getBanco().equals("Star Bank")){
            descuento = 20;
        }
        return descuento;
    }
}
