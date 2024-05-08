package dh.backend.model;

import java.time.LocalDate;
import java.util.Objects;

public class Hotel {
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private String ciudad;

    public Hotel(LocalDate fechaEntrada, LocalDate fechaSalida, String ciudad) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.ciudad = ciudad;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(fechaEntrada, hotel.fechaEntrada) && Objects.equals(fechaSalida, hotel.fechaSalida) && Objects.equals(ciudad, hotel.ciudad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaEntrada, fechaSalida, ciudad);
    }
}
