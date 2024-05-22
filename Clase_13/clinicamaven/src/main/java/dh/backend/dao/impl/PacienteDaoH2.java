package dh.backend.dao.impl;

import dh.backend.dao.IDao;
import dh.backend.db.H2Connection;
import dh.backend.model.Domicilio;
import dh.backend.model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PacienteDaoH2 implements IDao<Paciente> {
    private static Logger LOGGER = Logger.getLogger(PacienteDaoH2.class);
    private static String SQL_INSERT = "INSERT INTO PACIENTES VALUES (DEFAULT,?,?,?,?,?)";
    private static String SQL_SELECT_ID = "SELECT * FROM PACIENTES WHERE ID=?";
    private static String SQL_SELECT_ALL = "SELECT * FROM PACIENTES";
    @Override
    public Paciente registrar(Paciente paciente) {
        Connection connection = null;
        DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();
        Paciente pacienteARetornar = null;
        try{
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            Domicilio domicilioGuardado = domicilioDaoH2.registrar(paciente.getDomicilio());

            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, paciente.getApellido());
            preparedStatement.setString(2, paciente.getNombre());
            preparedStatement.setString(3, paciente.getDni());
            preparedStatement.setDate(4, Date.valueOf(paciente.getFechaIngreso()));
            preparedStatement.setInt(5, domicilioGuardado.getId());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                Integer id= resultSet.getInt(1);
                pacienteARetornar = new Paciente(id, paciente.getApellido(), paciente.getNombre(),
                        paciente.getDni(), paciente.getFechaIngreso(), domicilioGuardado);
            }
            LOGGER.info("paciente guardado: "+ pacienteARetornar);

            connection.commit();
            connection.setAutoCommit(true);
        }catch (Exception e){
            if(connection!=null){
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    LOGGER.info(ex.getMessage());
                    ex.printStackTrace();
                }
            }
            LOGGER.info(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.info(e.getMessage());
                e.printStackTrace();
            }
        }

        return pacienteARetornar;
    }

    @Override
    public Paciente buscarPorId(Integer id) {
        Connection connection = null;
        Paciente pacienteEncontrado = null;
        DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();
        try {
            connection = H2Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Integer idDevuelto = resultSet.getInt(1);
                String apellido = resultSet.getString(2);
                String nombre = resultSet.getString(3);
                String dni = resultSet.getString(4);
                LocalDate fecha = resultSet.getDate(5).toLocalDate();
                Integer idDomicilio = resultSet.getInt(6);
                Domicilio domicilioEncontrado = domicilioDaoH2.buscarPorId(idDomicilio);
                pacienteEncontrado = new Paciente(idDevuelto, apellido, nombre,dni, fecha, domicilioEncontrado);
            }
            LOGGER.info("paciente encontrado: "+ pacienteEncontrado);

        }catch (Exception e){
            LOGGER.info(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.info(e.getMessage());
                e.printStackTrace();
            }
        }
        return pacienteEncontrado;
    }

    @Override
    public List<Paciente> buscarTodos() {
        List<Paciente> pacientes = new ArrayList<>();
        DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();
        Connection connection = null;
        try{
            connection = H2Connection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            while (resultSet.next()){
                Integer idDevuelto = resultSet.getInt(1);
                String apellido = resultSet.getString(2);
                String nombre = resultSet.getString(3);
                String dni = resultSet.getString(4);
                LocalDate fecha = resultSet.getDate(5).toLocalDate();
                Integer idDomicilio = resultSet.getInt(6);
                Domicilio domicilioEncontrado = domicilioDaoH2.buscarPorId(idDomicilio);
                Paciente paciente = new Paciente(idDevuelto, apellido, nombre,dni, fecha, domicilioEncontrado);

                LOGGER.info("paciente listado: "+ paciente);
                pacientes.add(paciente);
            }

        }catch (Exception e){
            LOGGER.info(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.info(e.getMessage());
                e.printStackTrace();
            }
        }
        return pacientes;
    }
}
