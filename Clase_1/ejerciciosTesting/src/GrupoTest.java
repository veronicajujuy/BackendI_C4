import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrupoTest {
    @Test
    @DisplayName("Testeo que los nombres sean mayores a 5 letras")
    void test1(){
        //dado
        Persona persona1 = new Persona("Juan", 19);
        Persona persona2 = new Persona("Pedro", 19);
        Persona persona3 = new Persona("Ana", 19);
        Persona persona4 = new Persona("Luz", 19);
        Persona persona5 = new Persona("Julian", 19);

        Grupo grupo = new Grupo();
        // cuando
        grupo.agregarPersona(persona1);
        grupo.agregarPersona(persona2);
        grupo.agregarPersona(persona3);
        grupo.agregarPersona(persona4);
        grupo.agregarPersona(persona5);

        // entonces
        int valorEsperado = 2;
        int valorObtenido = grupo.integrantes.size();
        assertEquals(valorEsperado, valorObtenido );

    }

    /*Dadas 5 personas (18 años, 17 años, 22 años, 14 años y 32 años), el tamaño de la colección debería ser 3.*/
    @Test
    @DisplayName("Testeo que las edades sean mayores a 18")
    void test2(){
        //dado
        Persona persona1 = new Persona("Pedro", 18);
        Persona persona2 = new Persona("Pedro", 17);
        Persona persona3 = new Persona("Pedro", 22);
        Persona persona4 = new Persona("Pedro", 14);
        Persona persona5 = new Persona("Pedro", 32);

        Grupo grupo = new Grupo();
        // cuando
        grupo.agregarPersona(persona1);
        grupo.agregarPersona(persona2);
        grupo.agregarPersona(persona3);
        grupo.agregarPersona(persona4);
        grupo.agregarPersona(persona5);

        // entonces
        int valorEsperado = 3;
        int valorObtenido = grupo.integrantes.size();
        assertEquals(valorEsperado, valorObtenido );

    }

    @Test
    @DisplayName("Testeo que los nombres tengan solo letras entre A y Z")
    void test3(){
        //dado
        Persona persona1 = new Persona("Pedro/", 19);
        Persona persona2 = new Persona("N1cola$", 19);
        Persona persona3 = new Persona("J4an", 19);
        Persona persona4 = new Persona("Ana\\", 19);
        Persona persona5 = new Persona("Soledad", 19);

        Grupo grupo = new Grupo();
        // cuando
        grupo.agregarPersona(persona1);
        grupo.agregarPersona(persona2);
        grupo.agregarPersona(persona3);
        grupo.agregarPersona(persona4);
        grupo.agregarPersona(persona5);

        // entonces
        int valorEsperado = 1;
        int valorObtenido = grupo.integrantes.size();
        assertEquals(valorEsperado, valorObtenido );

    }

}