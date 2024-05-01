package figuras;

public abstract class Figura {
    protected double valor;

    public Figura(double valor) {
        this.valor = valor;
    }

    public abstract String area();
}
