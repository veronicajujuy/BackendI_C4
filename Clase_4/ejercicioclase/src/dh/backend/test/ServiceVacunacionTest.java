package dh.backend.test;

import dh.backend.model.Persona;
import dh.backend.service.ProxyVacunacion;
import dh.backend.service.ServiceVacunacion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ServiceVacunacionTest {
    @Test
    @DisplayName("La persona se puede vacunar")
    void test1(){
        //dado
        Persona persona = new Persona("Juan","Perez","4646546", LocalDate.of(2024,04,15),"Antigripal");
        ServiceVacunacion serviceVacunacion = new ProxyVacunacion();
        // cuando
        String respuesta = serviceVacunacion.vacunar(persona);
        // entonces
        assertEquals("La persona: Juan Perez se vacunó con : Antigripal", respuesta);
    }

    @Test
    @DisplayName("La persona no se puede vacunar")
    void test2(){
        //dado
        Persona persona = new Persona("Juan","Perez","4646546", LocalDate.of(2024,05,10),"Antigripal");
        ServiceVacunacion serviceVacunacion = new ProxyVacunacion();
        // cuando
        String respuesta = serviceVacunacion.vacunar(persona);
        // entonces
        assertEquals("La persona no cumple con los requisitos", respuesta);
    }

}