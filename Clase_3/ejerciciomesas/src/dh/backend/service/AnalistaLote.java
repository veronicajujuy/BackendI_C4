package dh.backend.service;

import dh.backend.model.Articulo;

public class AnalistaLote extends AnalistaCalidad{
    @Override
    public String validarCalidadDelProducto(Articulo articulo) {
        if(articulo.getLote()>= 1000 && articulo.getLote()<=2000){
            return super.getSiguienteAnalista().validarCalidadDelProducto(articulo);
        }
        return "El articulo no paso el control de Lote";
    }
}
