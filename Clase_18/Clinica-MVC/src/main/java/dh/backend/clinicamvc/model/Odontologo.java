package dh.backend.clinicamvc.model;

public class Odontologo {
    private Integer id;
    private String nroMatricula;
    private String nombre;
    private String apellido;

    public Odontologo() {
    }

    public Odontologo(String nroMatricula, String nombre, String apellido) {
        this.nroMatricula = nroMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Odontologo(int id, String nroMatricula, String nombre, String apellido) {
        this.id = id;
        this.nroMatricula = nroMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNroMatricula() {
        return nroMatricula;
    }

    public void setNroMatricula(String nroMatricula) {
        this.nroMatricula = nroMatricula;
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

    @Override
    public String toString() {
        return "Odontologo : " +
                "id=" + id +
                ", nroMatricula='" + nroMatricula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido;
    }
}
