package dh.backend.test;

import dh.backend.model.Articulo;
import dh.backend.service.CompruebaCalidad;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnalistaCalidadTest {
    @Test
    @DisplayName("El producto debe pasar todos los controles")
    void testPasaControles(){
        //dado
        Articulo articulo = new Articulo("Articulo1",1000,1300,"sano");
        CompruebaCalidad compruebaCalidad = new CompruebaCalidad();
        //cuando
        String respuestaObtenida = compruebaCalidad.validarCalidadProducto(articulo);
        //entonces
        assertEquals("El articulo paso todos los controles", respuestaObtenida);
    }

    @Test
    @DisplayName("El producto no debe pasar el control de lote")
    void testNoPasaControlLote(){
        //dado
        Articulo articulo = new Articulo("Articulo1",900,1300,"sano");
        CompruebaCalidad compruebaCalidad = new CompruebaCalidad();
        //cuando
        String respuestaObtenida = compruebaCalidad.validarCalidadProducto(articulo);
        //entonces
        assertEquals("El articulo no paso el control de Lote", respuestaObtenida);
    }

    @Test
    @DisplayName("El producto no debe pasar el control de peso")
    void testNoPasaControlPeso(){
        //dado
        Articulo articulo = new Articulo("Articulo1",1000,2000,"sano");
        CompruebaCalidad compruebaCalidad = new CompruebaCalidad();
        //cuando
        String respuestaObtenida = compruebaCalidad.validarCalidadProducto(articulo);
        //entonces
        assertEquals("El articulo no paso el control de Peso", respuestaObtenida);
    }

    @Test
    @DisplayName("El producto no debe pasar el control de envase")
    void testNoPasaControlEnvase(){
        //dado
        Articulo articulo = new Articulo("Articulo1",1000,1200,"defectuoso");
        CompruebaCalidad compruebaCalidad = new CompruebaCalidad();
        //cuando
        String respuestaObtenida = compruebaCalidad.validarCalidadProducto(articulo);
        //entonces
        assertEquals("El articulo no paso el control de Envasado", respuestaObtenida);
    }

}