package dh.backend;


import dh.backend.db.DBConnection;
import dh.backend.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;

public class Main {
    public static Logger LOGGER = Logger.getLogger(Main.class);
    public static String SQL_CREATE = "DROP TABLE IF EXISTS ODONTOLOGOS;" +
            "CREATE TABLE ODONTOLOGOS (ID INT AUTO_INCREMENT PRIMARY KEY," +
            "APELLIDO VARCHAR(50) NOT NULL, NOMBRE VARCHAR(50) NOT NULL, " +
            "MATRICULA VARCHAR(50) NOT NULL)";
    public static String SQL_INSERT = "INSERT INTO ODONTOLOGOS VALUES (DEFAULT, ?,?,?)";
    public static String SQL_UPDATE = "UPDATE ODONTOLOGOS SET MATRICULA = ? WHERE ID=?";
    public static String SQL_SELECT = "SELECT * FROM ODONTOLOGOS";

    public static void main(String[] args) {
        Connection connection = null;
        Odontologo odontologo = new Odontologo("Panico","Carlos","456");
        Odontologo odontologoDB = null;

        try {
            connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE);

            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, odontologo.getApellido());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getMatricula());
            preparedStatement.execute();

            ResultSet resultSet = statement.executeQuery(SQL_SELECT);
            while (resultSet.next()){
                odontologoDB = new Odontologo(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4));
            }
            odontologo.setId(odontologoDB.getId());
            LOGGER.info("odontologo desde la db: "+ odontologoDB);

            connection.setAutoCommit(false);
            String nuevaMatricula = "1234";
            try{
                preparedStatement = connection.prepareStatement(SQL_UPDATE);
                preparedStatement.setString(1, nuevaMatricula);
                preparedStatement.setInt(2, odontologo.getId());
                preparedStatement.execute();
                connection.commit();
            }catch (Exception e){
                connection.rollback();
            }
            odontologo.setMatricula(nuevaMatricula);
            connection.setAutoCommit(true);

            resultSet = statement.executeQuery(SQL_SELECT);
            while (resultSet.next()){
                odontologoDB = new Odontologo(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4));
            }
            LOGGER.info("odontologo desde la db: "+ odontologoDB);
            LOGGER.info("odontologo: "+ odontologo);

        } catch (Exception e){
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }
}
