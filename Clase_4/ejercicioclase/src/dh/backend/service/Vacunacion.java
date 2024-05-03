package dh.backend.service;

import dh.backend.model.Persona;

public class Vacunacion implements ServiceVacunacion{
    @Override
    public String vacunar(Persona persona) {
        return "La persona: "+persona.getNombre() + " "+ persona.getApellido()+ " se vacunó con : "+ persona.getVacuna();
    }
}
