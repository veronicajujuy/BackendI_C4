import java.util.ArrayList;
import java.util.List;


public class Grupo {
    List<Persona> integrantes;

    public Grupo() {
        integrantes = new ArrayList<>();
    }

    public List<Persona> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<Persona> integrantes) {
        this.integrantes = integrantes;
    }

    public void agregarPersona(Persona persona){
        if(persona.tiene18anios() && persona.nombreCincoLetras() && persona.nombreContieneSoloAZ()) {
            this.integrantes.add(persona);
        }
    }
}
