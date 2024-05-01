package dh.backend.service;

import dh.backend.model.Menu;

public class PreparadorInfantil extends PreparadorMenu {
    @Override
    public String armarMenu(Menu menu) {
        return "preparar menu infantil";
    }

    @Override
    public double calculoPrecio(Menu menu) {
        return menu.getPrecioBase()+ 3* menu.getJuguetes();
    }
}
