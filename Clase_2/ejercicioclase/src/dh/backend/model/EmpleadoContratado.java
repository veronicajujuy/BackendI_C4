package dh.backend.model;

public class EmpleadoContratado extends Empleado{
    private int cantHoras;
    private double tarifaPorHora;


    public EmpleadoContratado(String nombre, String apellido, String nroCuenta, int cantHoras, double tarifaPorHora) {
        super(nombre, apellido, nroCuenta);
        this.cantHoras = cantHoras;
        this.tarifaPorHora = tarifaPorHora;
    }

    public int getCantHoras() {
        return cantHoras;
    }

    public void setCantHoras(int cantHoras) {
        this.cantHoras = cantHoras;
    }

    public double getTarifaPorHora() {
        return tarifaPorHora;
    }

    public void setTarifaPorHora(double tarifaPorHora) {
        this.tarifaPorHora = tarifaPorHora;
    }
}
