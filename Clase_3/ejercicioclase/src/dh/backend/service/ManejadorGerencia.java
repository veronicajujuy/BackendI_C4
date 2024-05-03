package dh.backend.service;

import dh.backend.model.Mail;

public class ManejadorGerencia extends ManejadorMail{
    @Override
    public String comprobarMail(Mail mail) {
        if(mail.getTema().equalsIgnoreCase("gerencia")|| mail.getDestino().equalsIgnoreCase("gerencia@colmena.com")){
            return "El mail sera manejado por Gerencia";
        }
        System.out.println("Paso por gerencia");
        return getSiguiente().comprobarMail(mail);
    }
}
