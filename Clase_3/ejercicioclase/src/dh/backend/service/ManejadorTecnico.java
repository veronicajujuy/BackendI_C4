package dh.backend.service;

import dh.backend.model.Mail;

public class ManejadorTecnico extends ManejadorMail{
    @Override
    public String comprobarMail(Mail mail) {
        if(mail.getTema().equalsIgnoreCase("tecnico")||
                mail.getDestino().equalsIgnoreCase("tecnico@colmena.com")){
            return "El mail sera manejado por el Area tenica";
        }
        System.out.println("Paso por tecnico");
        return getSiguiente().comprobarMail(mail);
    }
}
