package dh.backend.service;

import dh.backend.model.Menu;

public class PreparadorClasico extends PreparadorMenu{
    @Override
    public String armarMenu(Menu menu) {
        return "preparar menu clasico";
    }

    @Override
    public double calculoPrecio(Menu menu) {
        return menu.getPrecioBase();
    }
}
