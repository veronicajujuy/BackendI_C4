package dh.backend.service;

import dh.backend.model.Usuario;

public class SpotifyDownload implements SpotifyService{
    @Override
    public String descargarMusica(Usuario usuario) {
        return "descargando musica...";
    }
}
