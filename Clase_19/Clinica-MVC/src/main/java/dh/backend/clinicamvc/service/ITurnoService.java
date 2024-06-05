package dh.backend.clinicamvc.service;

import dh.backend.clinicamvc.model.Paciente;
import dh.backend.clinicamvc.model.Turno;

import java.util.List;

public interface ITurnoService {
    Turno registrar(Turno turno);

    Turno buscarPorId(Integer id);

    List<Turno> buscarTodos();
    void actualizarTurno(Turno turno);
    void eliminarTurno(Integer id);
}
