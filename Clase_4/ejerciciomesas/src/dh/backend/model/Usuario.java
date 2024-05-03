package dh.backend.model;

public class Usuario {
    private String nombre;
    private String nroUsuario;
    private Tipo tipo;

    public Usuario(String nombre, String nroUsuario, Tipo tipo) {
        this.nombre = nombre;
        this.nroUsuario = nroUsuario;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNroUsuario() {
        return nroUsuario;
    }

    public void setNroUsuario(String nroUsuario) {
        this.nroUsuario = nroUsuario;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
