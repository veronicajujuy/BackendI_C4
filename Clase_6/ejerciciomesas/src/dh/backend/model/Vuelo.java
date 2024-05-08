package dh.backend.model;

import java.time.LocalDate;
import java.util.Objects;

public class Vuelo {
    private String origen;
    private String destino;
    private LocalDate fechaSalida;
    private LocalDate fechaLlegada;

    public Vuelo(String origen, String destino, LocalDate fechaSalida, LocalDate fechaLlegada) {
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vuelo vuelo = (Vuelo) o;
        return Objects.equals(origen, vuelo.origen) && Objects.equals(destino, vuelo.destino) && Objects.equals(fechaSalida, vuelo.fechaSalida) && Objects.equals(fechaLlegada, vuelo.fechaLlegada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(origen, destino, fechaSalida, fechaLlegada);
    }
}
