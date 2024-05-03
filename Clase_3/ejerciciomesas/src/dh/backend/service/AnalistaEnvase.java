package dh.backend.service;

import dh.backend.model.Articulo;

public class AnalistaEnvase extends AnalistaCalidad{
    @Override
    public String validarCalidadDelProducto(Articulo articulo) {
        if(articulo.getEnvasado().equalsIgnoreCase("sano")||articulo.getEnvasado().equalsIgnoreCase("casi sano")){
            return "El articulo paso todos los controles";
        }
        return "El articulo no paso el control de Envasado";
    }
}
