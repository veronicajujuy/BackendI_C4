package dh.backend.test;

import dh.backend.model.Mail;
import dh.backend.service.ProcesarMail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManejadorMailTest {
    @Test
    @DisplayName("Testear que el mail lo maneje Comercial")
    void test1(){
        //dado
        Mail mail = new Mail("empresax@gmail.com","nose@colmena.com","comercial");
        ProcesarMail procesarMail = new ProcesarMail();
        //cuando
        String respuesta = procesarMail.cadenaResponsabilidadMail(mail);
        //entonces
        assertEquals("El mail sera manejado por el Area Comercial",respuesta);
    }

    @Test
    @DisplayName("Testear que el mail vaya a spam")
    void test2(){
        //dado
        Mail mail = new Mail("empresax@gmail.com","nose@colmena.com","alguna oferta");
        ProcesarMail procesarMail = new ProcesarMail();
        //cuando
        String respuesta = procesarMail.cadenaResponsabilidadMail(mail);
        //entonces
        assertEquals("El mail sera enviado a spam",respuesta);
    }

}