package figuras;

public class Cuadrado extends Figura{

    public Cuadrado(double valor) {
        super(valor);
    }

    @Override
    public String area() {
        if(valor <= 0) return "El valor del radio o lado debe ser mayor que cero";
        double area =valor * valor;
        return "El área del cuadrado es "+ area+ " unidades";
    }
}
