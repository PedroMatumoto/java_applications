package aula9.ex2;

public class Teste {
    public static void main(String[] args) {

        Triangle triangulo= new Triangle(3,4);
        Square quadrado = new Square(5);
        Cube cubo = new Cube(5);
        Circle circulo = new Circle(5);
        Sphere esfera = new Sphere(5);
        Tetrahedron Tetrahedron = new Tetrahedron(5);

        System.out.println("Triangulo: ");
        System.out.println("Area: " + triangulo.sem_casasArea());
        System.out.println("Area: " + triangulo.com2_casasArea());
        System.out.println("Perimetro: " + triangulo.sem_casasPerimetro());
        System.out.println("Perimetro: " + triangulo.com2_casasPerimetro());

        System.out.println("==========");

        System.out.println("Quadrado: ");
        System.out.println("Area: " + quadrado.sem_casasArea());
        System.out.println("Area: " + quadrado.com2_casasArea());
        System.out.println("Perimetro: " + quadrado.sem_casasPerimetro());
        System.out.println("Perimetro: " + quadrado.com2_casasPerimetro());

        System.out.println("==========");

        System.out.println("Cubo: ");
        System.out.println("Volume: " + cubo.sem_casasVolume());
        System.out.println("Volume: " + cubo.com2_casasVolume());
        System.out.println("Area: " + cubo.sem_casasArea());
        System.out.println("Area: " + cubo.com2_casasArea());

        System.out.println("==========");

        System.out.println("Circulo: ");
        System.out.println("Area: " + circulo.sem_casasArea());
        System.out.println("Area: " + circulo.com2_casasArea());
        System.out.println("Perimetro: " + circulo.sem_casasPerimetro());
        System.out.println("Perimetro: " + circulo.com2_casasPerimetro());

        System.out.println("==========");

        System.out.println("Esfera: ");
        System.out.println("Volume: " + esfera.sem_casasVolume());
        System.out.println("Volume: " + esfera.com2_casasVolume());
        System.out.println("Area: " + esfera.sem_casasArea());
        System.out.println("Area: " + esfera.com2_casasArea());

        System.out.println("==========");

        System.out.println("Tetrahedron: ");
        System.out.println("Volume: " + Tetrahedron.sem_casasVolume());
        System.out.println("Volume: " + Tetrahedron.com2_casasVolume());
        System.out.println("Area: " + Tetrahedron.sem_casasArea());
        System.out.println("Area: " + Tetrahedron.com2_casasArea());



        
    }
}
