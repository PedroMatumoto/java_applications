package aula9.ex2;

public class Triangle extends TwoDimensionalShape {
    private double base;
    private double altura;
    
    public Triangle(double base, double altura){
        this.base = base;
        this.altura = altura;
    }
    
    public double getArea(){
        return base*altura/2;
    }
    
    public double getPerimetro(){
        return 3*base;
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
