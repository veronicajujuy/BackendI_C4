package dh.backend.service;

import dh.backend.model.Persona;

import java.time.LocalDate;

public class ProxyVacunacion implements ServiceVacunacion{

    Vacunacion vacunacion;

    public ProxyVacunacion() {
        vacunacion = new Vacunacion();
    }

    @Override
    public String vacunar(Persona persona) {
        if(persona.getFechaVacunacion().isEqual(LocalDate.now())|| persona.getFechaVacunacion().isBefore(LocalDate.now()) ){
            return vacunacion.vacunar(persona);
        }
        return "La persona no cumple con los requisitos";
    }
}
