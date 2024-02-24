package ex2;

interface Operacao{
    int executar(int x, int y);
}

public class ExemploFuncaoAnonima {
    public static void main(String[] args) {
        Operacao adicao = new Operacao() {
            @Override
            public int executar(int x, int y) {
                return x + y;
            }
        };
        int resultado = adicao.executar(10, 20);
        System.out.println("Resultado: "+resultado);
    }

    
}
