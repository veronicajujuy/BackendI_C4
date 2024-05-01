package figuras;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FiguraTest {
    @Test
    void chequearValoresCeroCuadrado(){
        //cuando
        Figura cuadrado = new Cuadrado(0);
        // act
        String esperado = "El valor del radio o lado debe ser mayor que cero";

        assertEquals(esperado, cuadrado.area());
    }

    @Test
    void chequearValoresCeroCirulo(){
        //dado
        Figura circulo = new Circulo(0);
        // cuando
        String esperado = "El valor del radio o lado debe ser mayor que cero";
        // entonces
        assertEquals(esperado, circulo.area());
    }

    @Test
    void chequearValoresCirulo(){
        //dado
        Figura circulo = new Circulo(10);
        // cuando
        String esperado = "El área del Circulo es 314.0 unidades";
        // entonces
        assertEquals(esperado, circulo.area());
    }

    @Test
    void chequearValoresCuadrado(){
        //dado
        Figura cuadrado = new Cuadrado(10);
        // cuando
        String esperado = "El área del cuadrado es 100.0 unidades";
        // entonces
        assertEquals(esperado, cuadrado.area());
    }


}