package aula9.ex2;

public abstract class Shape {
    private abstract class TwoDimensionalShape extends Shape{
        public abstract double getArea();
        public abstract double getPerimetro();
        public abstract String sem_casas();
        public abstract String com2_casas();
    }
    private abstract class ThreeDimensionalShape extends Shape {
        public abstract double getVolume();
        public abstract double getArea();
        public abstract String sem_casas();
        public abstract String com2_casas();
    }
}
