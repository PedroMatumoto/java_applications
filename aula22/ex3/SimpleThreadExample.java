package ex3;

import java.util.Random;
public class SimpleThreadExample {

    private static final long TOTAL_NUMEROS = 1_000_000_000L;
    
    public static void main(String[] args) {
        final int threads = 1;
        System.out.println("Missao: Gerar um bilhao de numeros aleatorios");
        System.out.println("Criando "+threads+" threads");
        new SimpleThreadExample().run();
    }

    public void run(){
        System.out.println("Iniciando Thread Principal");
        final double startTime = System.currentTimeMillis();

        Random rand = new Random();

        for (int i = 0; i < TOTAL_NUMEROS; i++) {
            Math.pow(rand.nextDouble(), 10);
        }

        final double totalSecs = (System.currentTimeMillis() - startTime) / 1000;
        System.out.println("Encerrando Thread Principal");
        System.out.println("Tempo total: "+totalSecs+" segundos");
    }
}
