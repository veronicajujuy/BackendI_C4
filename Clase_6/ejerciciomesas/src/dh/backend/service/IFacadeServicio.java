package dh.backend.service;

import java.time.LocalDate;

public interface IFacadeServicio {
    boolean buscarServicio(String origen, String destino, LocalDate fechaInicio, LocalDate fechaFin);
}
