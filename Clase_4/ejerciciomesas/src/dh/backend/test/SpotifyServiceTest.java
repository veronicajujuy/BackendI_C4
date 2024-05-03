package dh.backend.test;

import dh.backend.model.Tipo;
import dh.backend.model.Usuario;
import dh.backend.service.ProxySpotify;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpotifyServiceTest {
    @Test
    @DisplayName("Testear que un usuario free no puede descargar canciones")
    void testearNoPuedeDescargarMusica(){
        Usuario usuario = new Usuario("JuanPerez","45646", Tipo.FREE);
        ProxySpotify proxySpotify = new ProxySpotify();

        String respuestaEsperada = "Si quiere descargar musica suscribase al servicio premium";
        assertEquals(respuestaEsperada, proxySpotify.descargarMusica(usuario));
    }

    @Test
    @DisplayName("Testear que un usuario premium puede descargar canciones")
    void testearPuedeDescargarMusica(){
        Usuario usuario = new Usuario("JuanPerez","45646", Tipo.PREMIUM);
        ProxySpotify proxySpotify = new ProxySpotify();

        String respuestaEsperada = "descargando musica...";
        assertEquals(respuestaEsperada, proxySpotify.descargarMusica(usuario));
    }
}