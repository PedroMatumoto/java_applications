package aula5.lab;

import java.util.Scanner;

public class ex19 {
    public static void main(String[] args) {
        int i = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Limite:");
        int limite = sc.nextInt();
        System.out.println("Passo:");
        int passo = sc.nextInt();


        System.out.println("\n");

        while (i < limite) {
            i+=passo;
            System.out.println(i);
        }
    }

}
