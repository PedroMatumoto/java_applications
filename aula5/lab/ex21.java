package aula5.lab;

import java.util.Scanner;

public class ex21 {
    public static void main(String[] args) {
        int i = 1;

        Scanner sc = new Scanner(System.in);
        System.out.println("Limite:");
        int limite = sc.nextInt();

        System.out.println("\n");

        while (i < limite) {
            if (i % 2 == 1) {
                System.out.println(i);
            }
            i++;
        }
    }

}
