package dh.backend.clinicamvc.dao;

import java.util.List;

public interface IDao <T>{
    T registrar (T t);
    T buscarPorId(Integer id);
    List<T> buscarTodos();
}
