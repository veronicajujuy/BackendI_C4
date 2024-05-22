package service.test;

import dh.backend.dao.impl.PacienteDaoH2;
import dh.backend.model.Domicilio;
import dh.backend.model.Paciente;
import dh.backend.service.PacienteService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PacienteServiceTest {
    private static Logger LOGGER = Logger.getLogger(PacienteServiceTest.class);
    private static PacienteService pacienteService = new PacienteService(new PacienteDaoH2());
    @BeforeAll
    static void crearTablas(){
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/clinicamaven2205;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }

    @Test
    @DisplayName("Testear que un paciente fue guardado")
    void testPacienteGuardado(){
        Paciente paciente = new Paciente("Cosme","Menganito","456464", LocalDate.of(2024,04,22),
                new Domicilio("Calle Falsa", 456, "Springfield","Montana"));
        Paciente pacienteDesdeLaBD = pacienteService.registrarPaciente(paciente);

        assertNotNull(pacienteDesdeLaBD);
    }

    @Test
    @DisplayName("Testear busqueda paciente por id")
    void testPacientePorId(){
        Integer id = 1;
        Paciente pacienteEncontrado = pacienteService.buscarPorId(id);

        assertEquals(id, pacienteEncontrado.getId());
    }

    @Test
    @DisplayName("Testear busqueda todos los pacientes")
    void testBusquedaTodos() {
        Paciente paciente = new Paciente("Cosme","Menganito","456464", LocalDate.of(2024,04,22),
                new Domicilio("Calle Falsa", 456, "Springfield","Montana"));
        pacienteService.registrarPaciente(paciente);

        List<Paciente> pacientes = pacienteService.buscarTodos();

        assertTrue(pacientes.size()!=0);

    }


}