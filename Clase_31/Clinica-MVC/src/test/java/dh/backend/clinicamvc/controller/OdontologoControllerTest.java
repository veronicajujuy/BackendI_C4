package dh.backend.clinicamvc.controller;

import dh.backend.clinicamvc.service.IOdontologoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class OdontologoControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private IOdontologoService odontologoService;

    @Test
    @DisplayName("Testear la obtencion de un odontologo")
    void obtenerOdontologo() throws Exception {
        mockMvc.perform(get("/odontologo/1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath(("$.nombre")).value("Carlos"))
                .andExpect(jsonPath(("$.apellido")).value("Llanos"))
                .andExpect(jsonPath(("$.nroMatricula")).value( "112"));
    }

    @Test
    @DisplayName("Testear que un odontologo no exista")
    void noObtenerOdontologo() throws Exception {
        mockMvc.perform(get("/odontologo/12")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Testear que se agrego un odontologo a la base de datos")
    void registrarOdontologo() throws Exception {
        String odontologo = "{\"nombre\":\"Juan\",\"apellido\":\"Perez\",\"nroMatricula\":\"1234\"}";

        mockMvc.perform(post("/odontologo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(odontologo))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath(("$.nombre")).value("Juan"))
                .andExpect(jsonPath(("$.apellido")).value("Perez"))
                .andExpect(jsonPath(("$.nroMatricula")).value( "1234"));

    }
}