package dh.backend.service;

import java.time.LocalDate;

public class FacadeServicio implements IFacadeServicio{
    ApiHotel apiHotel;
    ApiVuelo apiVuelo;

    public FacadeServicio() {
        apiHotel = new ApiHotel();
        apiVuelo = new ApiVuelo();
    }

    @Override
    public boolean buscarServicio(String origen, String destino, LocalDate fechaInicio, LocalDate fechaFin) {
        boolean respuestaHotel = apiHotel.buscarHotel(fechaInicio, fechaFin, destino);
        boolean respuestaVuelo = apiVuelo.buscarVuelos(fechaInicio, fechaFin, origen, destino);
        return respuestaVuelo && respuestaHotel;
    }
}
