package dh.backend.service;

import dh.backend.model.Hotel;
import dh.backend.model.Vuelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ApiVuelo {
    List<Vuelo> vuelos;

    public ApiVuelo() {
        vuelos = new ArrayList<>();
        cargarVuelos();
    }
    public boolean buscarVuelos(LocalDate fechaIngreso, LocalDate fechaEgreso, String origen, String destino){
        boolean respuesta = false;
        Vuelo vueloABuscar = new Vuelo(origen, destino, fechaIngreso, fechaEgreso);
        for (Vuelo vuelo : vuelos) {
            if(vuelo.equals(vueloABuscar)){
                System.out.println("El vuelo esta disponible");
                respuesta = true;
            }
        }
        return respuesta;
    }

    public void cargarVuelos() {
        vuelos.add(new Vuelo("Buenos Aires","Los Angeles" , LocalDate.of(2024,06,15),LocalDate.of(2024,06,20) ));
        vuelos.add(new Vuelo("Santiago", "Paris", LocalDate.of(2024,07,10),LocalDate.of(2024,07,15) ));
    }
}
