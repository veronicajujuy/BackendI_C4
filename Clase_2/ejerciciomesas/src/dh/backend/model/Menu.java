package dh.backend.model;

public class Menu {
    private double precioBase;
    private double recargoEspecias ;
    private int salsas;
    private double juguetes;

    public Menu(double precioBase, double recargoEspecias, int salsas, double juguetes) {
        this.precioBase = precioBase;
        this.recargoEspecias = recargoEspecias;
        this.salsas = salsas;
        this.juguetes = juguetes;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public double getRecargoEspecias() {
        return recargoEspecias;
    }

    public void setRecargoEspecias(double recargoEspecias) {
        this.recargoEspecias = recargoEspecias;
    }

    public int getSalsas() {
        return salsas;
    }

    public void setRecargoSalsas(int recargoSalsas) {
        this.salsas = recargoSalsas;
    }

    public double getJuguetes() {
        return juguetes;
    }

    public void setJuguetes(double juguetes) {
        this.juguetes = juguetes;
    }
}
