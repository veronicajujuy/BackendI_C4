package dh.backend.service;

import dh.backend.model.Tipo;
import dh.backend.model.Usuario;

public class ProxySpotify implements SpotifyService{
    SpotifyDownload spotifyDownload;

    public ProxySpotify() {
        this.spotifyDownload = new SpotifyDownload();
    }

    @Override
    public String descargarMusica(Usuario usuario) {
        if(usuario.getTipo().equals(Tipo.FREE)){
            return "Si quiere descargar musica suscribase al servicio premium";
        }
        return spotifyDownload.descargarMusica(usuario);
    }
}
