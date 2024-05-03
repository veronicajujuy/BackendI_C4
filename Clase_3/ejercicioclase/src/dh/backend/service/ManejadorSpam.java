package dh.backend.service;

import dh.backend.model.Mail;

public class ManejadorSpam extends ManejadorMail{

    @Override
    public String comprobarMail(Mail mail) {
        System.out.println("termino en spam");
        return "El mail sera enviado a spam";
    }
}
