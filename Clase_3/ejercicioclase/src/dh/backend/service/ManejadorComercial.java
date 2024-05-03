package dh.backend.service;

import dh.backend.model.Mail;

public class ManejadorComercial extends ManejadorMail{

    @Override
    public String comprobarMail(Mail mail) {
        if(mail.getTema().equalsIgnoreCase("comercial")||
                mail.getDestino().equalsIgnoreCase("comercial@colmena.com")){
            return "El mail sera manejado por el Area Comercial";
        }
        System.out.println("Paso por comercial");
        return getSiguiente().comprobarMail(mail);
    }
}
