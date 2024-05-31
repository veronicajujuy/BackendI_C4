package dh.backend.clinicamvc.service;

import dh.backend.clinicamvc.dao.IDao;
import dh.backend.clinicamvc.model.Paciente;

import java.util.List;

public interface IPacienteService {

    Paciente registrarPaciente(Paciente paciente);

    Paciente buscarPorId(Integer id);

    List<Paciente> buscarTodos();
    void actualizarPaciente(Paciente paciente);
    void eliminarPaciente(Integer id);
}
