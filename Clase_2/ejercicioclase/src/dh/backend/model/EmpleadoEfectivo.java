package dh.backend.model;

public class EmpleadoEfectivo extends Empleado{
    private double sueldoBase;
    private double descuentos;
    private double premios;

    public EmpleadoEfectivo(String nombre, String apellido, String nroCuenta, double sueldoBase, double descuentos, double premios) {
        super(nombre, apellido, nroCuenta);
        this.sueldoBase = sueldoBase;
        this.descuentos = descuentos;
        this.premios = premios;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public double getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(double descuentos) {
        this.descuentos = descuentos;
    }

    public double getPremios() {
        return premios;
    }

    public void setPremios(double premios) {
        this.premios = premios;
    }
}
