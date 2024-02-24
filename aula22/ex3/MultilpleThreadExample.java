package ex3;

import java.util.Random;

public class MultilpleThreadExample extends Thread {
    
        private static final long TOTAL_NUMEROS = 1_000_000_000L;
        private static long numerosAGerar;


        public MultilpleThreadExample(long numerosAGerar){
            this.numerosAGerar = numerosAGerar;
            System.out.printf("----> Thread criada (%s)!\n ", getName());
        }
    
        public static void main(String[] args) {
            final int threads = args.length == 0 ? 1 : Integer.valueOf(args[0]);
            final long numeroPorThread = TOTAL_NUMEROS / threads;
            System.out.println("Missao: Gerar um bilhao de numeros aleatorios usando Threads\n");
            System.out.printf("-> Thread inciada (%s)...\n",Thread.currentThread().getName());
            System.out.printf("Criando +%d  Thread(s) para isso: \n", threads);
            final double startTime = System.currentTimeMillis();
            for (int i = 0; i < threads; i++) {
                new MultilpleThreadExample(numeroPorThread).start();
            }
            final double totalSecs = (System.currentTimeMillis() - startTime) / 1000;
            System.out.printf("-> Thread finalizada (%s) em %.2fs!\n",Thread.currentThread().getName(), totalSecs);
        }

        @Override
        public void run(){
            System.out.printf("-> Thread iniciada (%s)...\n", Thread.currentThread().getName());
            final double startTime = System.currentTimeMillis();
            Random rand = new Random();
            for (int i = 0; i < numerosAGerar; i++) {
                Math.pow(rand.nextDouble(), 10);
            }
            final double totalSecs = (System.currentTimeMillis() - startTime) / 1000;
            System.out.printf("-> Encerrando Thread (%s)...\n", Thread.currentThread().getName());
            System.out.printf("-> Thread finalizada (%s) em %.2fs!\n", Thread.currentThread().getName(), totalSecs);
        }
    
}
