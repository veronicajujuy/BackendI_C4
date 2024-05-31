package dh.backend.clinicamvc.dao.impl;

import dh.backend.clinicamvc.dao.IDao;
import dh.backend.clinicamvc.db.H2Connection;
import dh.backend.clinicamvc.model.Odontologo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OdontologoIDaoH2 implements IDao<Odontologo> {

    public static final Logger LOGGER = LoggerFactory.getLogger(OdontologoIDaoH2.class);
    public static final String INSERT = "INSERT INTO ODONTOLOGOS VALUES (DEFAULT,?,?,?)";
    public static final String BUSCAR_ID = "SELECT * FROM ODONTOLOGOS WHERE ID = ?";
    public static final String BUSCAR_ALL = "SELECT * FROM ODONTOLOGOS";


    @Override
    public Odontologo registrar(Odontologo odontologo) {
        Connection connection = null;
        Odontologo odontologoGuardado = null;
        try{
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,odontologo.getNroMatricula());
            preparedStatement.setString(2,odontologo.getNombre());
            preparedStatement.setString(3,odontologo.getApellido());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while(resultSet.next()){
                int idResultante = resultSet.getInt(1);
                odontologoGuardado = new Odontologo(idResultante, odontologo.getNroMatricula(), odontologo.getNombre(),
                        odontologo.getApellido());
            }
            LOGGER.info("Odontologo guardado: "+ odontologoGuardado);
            connection.commit();
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error(e.getMessage());
            if(connection!=null){
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    LOGGER.error(ex.getMessage());
                }
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.info(e.getMessage());
            }
        }
        return odontologoGuardado;
    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        Connection connection = null;
        Odontologo odontologoEncontrado = null;
        try{
            connection = H2Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(BUSCAR_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                odontologoEncontrado = crearOdontologo(resultSet);
            }
            LOGGER.info("Odontologo encontrado: "+odontologoEncontrado);

        } catch (ClassNotFoundException e) {
            LOGGER.error(e.getMessage());
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return odontologoEncontrado;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        Connection connection = null;
        List<Odontologo> odontologos = new ArrayList<>();
        Odontologo odontologoObtenido = null;
        try{
            connection = H2Connection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(BUSCAR_ALL);
            while (resultSet.next()){
                odontologoObtenido = crearOdontologo(resultSet);
                odontologos.add(odontologoObtenido);
                LOGGER.info("Agregando : "+odontologoObtenido);
            }

        } catch (ClassNotFoundException e) {
            LOGGER.error(e.getMessage());
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return odontologos;
    }

    @Override
    public void actualizar(Odontologo odontologo) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    private Odontologo crearOdontologo(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        String nro_matricula = resultSet.getString(2);
        String nombre = resultSet.getString(3);
        String apellido = resultSet.getString(4);
        Odontologo odontologo = new Odontologo(id, nro_matricula,nombre,apellido);
        return odontologo;
    }
}
