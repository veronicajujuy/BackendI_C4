package dh.backend.model;

import java.time.LocalDate;

public class Persona {
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaVacunacion;
    private String vacuna;

    public Persona(String nombre, String apellido, String dni, LocalDate fechaVacunacion, String vacuna) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaVacunacion = fechaVacunacion;
        this.vacuna = vacuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaVacunacion() {
        return fechaVacunacion;
    }

    public void setFechaVacunacion(LocalDate fechaVacunacion) {
        this.fechaVacunacion = fechaVacunacion;
    }

    public String getVacuna() {
        return vacuna;
    }

    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }
}
