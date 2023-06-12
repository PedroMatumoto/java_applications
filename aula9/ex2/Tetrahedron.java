package aula9.ex2;

public class Tetrahedron extends ThreeDimensionalShape{
    private double a;
    
    public Tetrahedron(double a) {
        this.a = a;
    }
    
    public double getVolume() {
        return (Math.pow(a, 3) / (6 * Math.sqrt(2)));
    }
    
    public double getArea() {
        return (Math.pow(a, 2) * Math.sqrt(3));
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
