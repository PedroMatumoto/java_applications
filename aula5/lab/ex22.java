package aula5.lab;

import java.util.Scanner;

public class ex22 {
    public static void main(String[] args) {
        int i = 1;

        Scanner sc =new Scanner(System.in);
        System.out.println("Quantos?");
        int contador = sc.nextInt();

        System.out.println("\n");


        while (contador>0&&i<1000000000) {
            if (i % 2 == 0) {
                System.out.println(i);
                contador--;
            }
            i++;
        }
    }

}
