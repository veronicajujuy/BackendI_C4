package dh.backend.service;

import dh.backend.model.Menu;

public abstract class PreparadorMenu {
    public String prepararMenu(Menu menu){
        String respuesta = null;
        String armando = armarMenu(menu);
        double precio = calculoPrecio(menu);
        return "El menu se prepara: "+armando+" y tiene un costo de: "+precio;
    }
    public abstract String armarMenu(Menu menu);
    public abstract double calculoPrecio(Menu menu);
}
