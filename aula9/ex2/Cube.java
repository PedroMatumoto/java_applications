package aula9.ex2;

public class Cube extends ThreeDimensionalShape {
    private double lado;
    
    public Cube(double lado) {
        this.lado = lado;
    }
    
    public double getlado() {
        return lado;
    }
    
    public void setlado(double lado) {
        this.lado = lado;
    }
    
    @Override
    public double getArea() {
        return 6 * lado * lado;
    }
    
    @Override
    public double getVolume() {
        return lado * lado * lado;
    } 

    public String sem_casasVolume() {
        return String.format("%.0f", getVolume());
    }

    public String com2_casasVolume() {
        return String.format("%.2f", getVolume());
    }

    public String sem_casasArea() {
        return String.format("%.0f", getArea());
    }

    public String com2_casasArea() {
        return String.format("%.2f", getArea());
    }


}
