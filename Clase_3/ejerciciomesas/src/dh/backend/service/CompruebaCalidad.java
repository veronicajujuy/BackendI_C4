package dh.backend.service;

import dh.backend.model.Articulo;

public class CompruebaCalidad {
    AnalistaCalidad analistaLote;
    public CompruebaCalidad() {
        analistaLote = new AnalistaLote();
        AnalistaCalidad analistaPeso = new AnalistaPeso();
        AnalistaCalidad analistaEnvase = new AnalistaEnvase();

        analistaLote.setSiguienteAnalista(analistaPeso);
        analistaPeso.setSiguienteAnalista(analistaEnvase);
    }

    public String validarCalidadProducto(Articulo articulo){
        return analistaLote.validarCalidadDelProducto(articulo);
    }
}
