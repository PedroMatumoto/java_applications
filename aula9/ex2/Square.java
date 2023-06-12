package aula9.ex2;

public class Square extends TwoDimensionalShape{
    private double lado;
    
    public Square(double lado){
        this.lado = lado;
    }
    
    public double getArea(){
        return lado*lado;
    }
    
    public double getPerimetro(){
        return 4*lado;
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
