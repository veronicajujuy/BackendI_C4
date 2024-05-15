package dh.backend.dao;

import java.util.List;

public interface IDao<T> {
    T registrar(T t);
    T buscarPorCampo(String campo);
    T buscarPorId(Integer id);
    List<T> buscarTodos();

}
