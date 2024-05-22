package dh.backend.dao.impl;

import dh.backend.dao.IDao;
import dh.backend.model.Paciente;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PacienteEnMemoria implements IDao<Paciente> {
    private Logger LOGGER = Logger.getLogger(PacienteEnMemoria.class);
    List<Paciente> pacientes = new ArrayList<>();
    @Override
    public Paciente registrar(Paciente paciente) {
        Integer id = pacientes.size()+1;
        paciente.setId(id);

        pacientes.add(paciente);
        LOGGER.info("paciente guardado: "+ paciente);
        return paciente;
    }

    @Override
    public Paciente buscarPorId(Integer id) {
        for(Paciente paciente: pacientes){
            if(paciente.getId().equals(id)){
                LOGGER.info("Paciente encontrado: "+ paciente);
                return paciente;
            }
        }
        LOGGER.info("Paciente no encontrado");
        return null;
    }

    @Override
    public List<Paciente> buscarTodos() {
        return pacientes;
    }
}
