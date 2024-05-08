package dh.backend.test;

import dh.backend.model.Hotel;
import dh.backend.model.Vuelo;
import dh.backend.service.FacadeServicio;
import dh.backend.service.IFacadeServicio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class IFacadeServicioTest {
    @Test
    @DisplayName("Testar que exista el servicio")
    void existeServicio(){

        IFacadeServicio facadeServicio = new FacadeServicio();
        boolean respuesta = facadeServicio.buscarServicio("Buenos Aires","Los Angeles" , LocalDate.of(2024,06,15),LocalDate.of(2024,06,20));

        assertTrue(respuesta);
    }

}