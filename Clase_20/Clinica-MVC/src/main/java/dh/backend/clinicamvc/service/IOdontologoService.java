package dh.backend.clinicamvc.service;


import dh.backend.clinicamvc.model.Odontologo;

import java.util.List;

public interface IOdontologoService {
    Odontologo agregarOdontologo(Odontologo odontologo);

    Odontologo buscarUnOdontologo(Integer id);
    List<Odontologo> buscarTodosOdontologos();

    void modificarOdontologo(Odontologo odontologo);
    void eliminarOdontologo(Integer id);
}
