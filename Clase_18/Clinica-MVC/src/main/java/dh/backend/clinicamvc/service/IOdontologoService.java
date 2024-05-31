package dh.backend.clinicamvc.service;


import dh.backend.clinicamvc.model.Odontologo;

import java.util.List;

public interface IOdontologoService {
    Odontologo agregarOdontologo(Odontologo odontologo);

    Odontologo buscarUnOdontologo(int id);
    List<Odontologo> buscarTodosOdontologos();
}
