package aula9.ex2;

public class Circle extends TwoDimensionalShape {
    private double raio;
    
    public Circle(double raio) {
        this.raio = raio;
    }
    
    public double getraio() {
        return this.raio;
    }
    
    @Override
    public double getArea() {
        return Math.PI * Math.pow(this.raio, 2);
    }
    
    @Override
    public double getPerimetro() {
        return 2 * Math.PI * this.raio;
    }

    public String sem_casasArea() {
        return String.format("%.0f", getArea());
    }

    public String com2_casasArea() {
        return String.format("%.2f", getArea());
    }

    public String sem_casasPerimetro() {
        return String.format("%.0f", getPerimetro());
    }

    public String com2_casasPerimetro() {
        return String.format("%.2f", getPerimetro());
    }
}
