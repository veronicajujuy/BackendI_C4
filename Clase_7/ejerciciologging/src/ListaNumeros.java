import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ListaNumeros {
    private static Logger LOGGER = Logger.getLogger(ListaNumeros.class);
    List<Integer> lista = new ArrayList<>();

    public void agregarNumeros(Integer numero){
        lista.add(numero);
        LOGGER.debug("numero agregado "+numero);
        if(lista.size() > 5){
            // loguear
            LOGGER.info("La lista tiene mas de 5 elementos");
        }
        if(lista.size() > 10){
            LOGGER.info("La lista tiene mas de 10 elementos");
        }
    }
    public double promedio(){
        double promedio = 0;
        Integer suma = 0;
        for(Integer numero: lista){
            suma += numero;
        }
        try {
            if(lista.isEmpty()) {
                throw new RuntimeException("La lista no puede tener cero elementos");
            }
            promedio = (double)suma / lista.size();
            LOGGER.info("el promedio es: " + promedio);
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        }

        return promedio;
    }
}
