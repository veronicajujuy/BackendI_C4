package dh.backend.test;

import dh.backend.model.Menu;
import dh.backend.service.PreparadorClasico;
import dh.backend.service.PreparadorMenu;
import dh.backend.service.PreparadorVegetariano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PreparadorMenuTest {
    @Test
    void testearMenuClasico(){
        // dado
        Menu menu = new Menu(5000,0.1,2,3);
        PreparadorMenu preparadorMenu = new PreparadorClasico();
        // cuando
        String respuestaEsperada = "El menu se prepara: preparar menu clasico y tiene un costo de: 5000.0";
        String respuestaObtenida = preparadorMenu.prepararMenu(menu);
        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    void testearMenuVegetariano(){
        // dado
        Menu menu = new Menu(5000,0.01,2,3);
        PreparadorMenu preparadorMenu = new PreparadorVegetariano();
        // cuando
        String respuestaEsperada = "El menu se prepara: preparar menu vegetariano y tiene un costo de: 5054.0";
        String respuestaObtenida = preparadorMenu.prepararMenu(menu);
        assertEquals(respuestaEsperada, respuestaObtenida);
    }
}