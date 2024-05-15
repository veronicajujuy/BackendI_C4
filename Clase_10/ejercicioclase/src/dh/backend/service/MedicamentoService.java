package dh.backend.service;

import dh.backend.dao.IDao;
import dh.backend.model.Medicamento;

import java.util.LinkedList;
import java.util.List;

public class MedicamentoService {
    private IDao<Medicamento> medicamentoIDao;

    public MedicamentoService(IDao<Medicamento> medicamentoIDao) {
        this.medicamentoIDao = medicamentoIDao;
    }

    public Medicamento registrarMedicamento(Medicamento medicamento){
        return medicamentoIDao.registrar(medicamento);
    }

    public Medicamento buscarPorNombre(String nombre){
        return medicamentoIDao.buscarPorCampo(nombre);
    }

    public Medicamento buscarPorId(Integer id){
        return medicamentoIDao.buscarPorId(id);
    }

    public List<Medicamento> buscarTodos(){
        return medicamentoIDao.buscarTodos();
    }

}
