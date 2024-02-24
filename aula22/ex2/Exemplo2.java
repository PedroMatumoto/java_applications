package ex2;

interface Operacao{
    int executar(int x, int y);
}

public class Exemplo2 {
    
    public static void main(String[] args) {
        Operacao adicao = (x, y) -> x + y;
        int resultado = adicao.executar(10, 20);
        System.out.println("Resultado: "+resultado);
    }
    
}
