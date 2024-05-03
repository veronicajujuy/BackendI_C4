package dh.backend.service;

import dh.backend.model.Articulo;

public abstract class AnalistaCalidad {
    private AnalistaCalidad siguienteAnalista;

    public AnalistaCalidad getSiguienteAnalista() {
        return siguienteAnalista;
    }

    public void setSiguienteAnalista(AnalistaCalidad siguienteAnalista) {
        this.siguienteAnalista = siguienteAnalista;
    }

    public abstract String validarCalidadDelProducto(Articulo articulo);
}
