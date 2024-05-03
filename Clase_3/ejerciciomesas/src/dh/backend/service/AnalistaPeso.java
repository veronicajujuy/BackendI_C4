package dh.backend.service;

import dh.backend.model.Articulo;

public class AnalistaPeso extends AnalistaCalidad{
    @Override
    public String validarCalidadDelProducto(Articulo articulo) {
        if(articulo.getPeso()>= 1200 && articulo.getPeso()<=1300){
            return getSiguienteAnalista().validarCalidadDelProducto(articulo);
        }
        return "El articulo no paso el control de Peso";
    }
}
