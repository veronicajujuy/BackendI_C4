package figuras;

public class Circulo extends Figura{
    private static final double PI = 3.14;

    public Circulo(double valor) {
        super(valor);
    }

    @Override
    public String area() {
        if(valor <= 0) return "El valor del radio o lado debe ser mayor que cero";
        double area =  PI*valor*valor;
        return "El área del Circulo es "+ area+ " unidades";
    }


}
