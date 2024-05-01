package dh.backend.service;

import dh.backend.model.Menu;

public class PreparadorVegetariano extends PreparadorMenu {
    @Override
    public String armarMenu(Menu menu) {
        return "preparar menu vegetariano";
    }

    @Override
    public double calculoPrecio(Menu menu) {
        return menu.getPrecioBase()+ (menu.getRecargoEspecias()*menu.getPrecioBase())+menu.getSalsas()*2;
    }
}
