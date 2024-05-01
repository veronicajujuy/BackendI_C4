package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClaseTest {
    @Test
     void testearQueSeanIguales(){
        int numero1 = 1;
        int numero2 = 1;

        assertEquals(numero1, numero2);
        assertNotEquals(numero1, 2);

    }

    @Test
    void testearQueSeaVerdaderoOFalso(){

        assertTrue(9>7);
        assertFalse(9<7);

    }

}
