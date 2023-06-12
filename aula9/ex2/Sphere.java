package aula9.ex2;

public class Sphere extends ThreeDimensionalShape{
    private double raio;
    
    public Sphere(double raio) {
        this.raio = raio;
    }
    
    public double getVolume() {
        return (4.0/3.0) * Math.PI * Math.pow(raio, 3);
    }
    
    public double getArea() {
        return 4 * Math.PI * Math.pow(raio, 2);
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
