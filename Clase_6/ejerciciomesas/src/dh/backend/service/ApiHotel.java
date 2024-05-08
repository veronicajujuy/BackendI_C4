package dh.backend.service;

import dh.backend.model.Hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ApiHotel {
    List<Hotel> hoteles;

    public ApiHotel() {
        hoteles = new ArrayList<>();
        cargarHoteles();
    }

    public boolean buscarHotel(LocalDate fechaIngreso, LocalDate fechaEgreso, String ciudad){
        boolean respuesta = false;
        Hotel hotelABuscar = new Hotel(fechaIngreso, fechaEgreso, ciudad);
        for (Hotel hotel: hoteles ) {
            if(hotel.equals(hotelABuscar)){
                System.out.println("El hotel esta disponible");
                respuesta = true;
            }
        }
        return respuesta;
    }

    public void cargarHoteles() {
        hoteles.add(new Hotel(LocalDate.of(2024,06,15),LocalDate.of(2024,06,20), "Los Angeles" ));
        hoteles.add(new Hotel(LocalDate.of(2024,07,10),LocalDate.of(2024,07,15), "Paris" ));
    }
}
