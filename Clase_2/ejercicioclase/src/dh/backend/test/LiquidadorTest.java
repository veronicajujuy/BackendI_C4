package dh.backend.test;

import dh.backend.model.Empleado;
import dh.backend.model.EmpleadoContratado;
import dh.backend.model.EmpleadoEfectivo;
import dh.backend.service.Liquidador;
import dh.backend.service.LiquidadorContratado;
import dh.backend.service.LiquidadorEfectivo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LiquidadorTest {
    @Test
    @DisplayName("Debería emitir un documento en papel cuando es un empleado efectivo")
    void testEmpleadoEfectivo(){
        //dado
        Empleado empleado1 = new EmpleadoEfectivo("Martin","Martini","454646",400,40,60);
        Liquidador liquidador = new LiquidadorEfectivo();
        // Cuando
        String respuestaObtenida = liquidador.LiquidarSueldos(empleado1);
        String respuestaEsperada = "La liquidación generada es un documento impreso Saldo a liquidar: 420.0";
        // entonces
        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    @DisplayName("Debería emitir un documento digital cuando es un empleado contratado")
    void testEmpleadoContratado(){
        //dado
        Empleado empleado1 = new EmpleadoContratado("Pompilia","Pompini","7864646",120,7);
        Liquidador liquidador = new LiquidadorContratado();
        // Cuando
        String respuestaObtenida = liquidador.LiquidarSueldos(empleado1);
        String respuestaEsperada = "La liquidación generada es un documento digital Saldo a liquidar: 840.0";
        // entonces
        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    @DisplayName(" El liquidador debería arrojar un mensaje de error cuando no es posible calcular la liquidación")
    void testEmpleadoIncorrecto(){
        //dado
        Empleado empleado1 = new EmpleadoContratado("Pompilia","Pompini","7864646",120,7);
        Liquidador liquidador = new LiquidadorEfectivo();
        // Cuando
        String respuestaObtenida = liquidador.LiquidarSueldos(empleado1);
        String respuestaEsperada = "La liquidación no pudo ser calculada";
        // entonces
        assertEquals(respuestaEsperada, respuestaObtenida);
    }


}