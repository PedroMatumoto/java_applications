package aula3;

import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class ex4 {

    public static void main(String args[]) {
        String word1;
        String word2;
        String word3;
        Scanner read = new Scanner(System.in);

        System.out.printf("First Word: \n");
        word1 = read.next();
        read.nextLine();

        System.out.printf("Second Word: \n");
        word2 = read.next();
        read.nextLine();

        System.out.printf("Third Word: \n");
        word3 = read.next();
        read.nextLine();


        System.out.printf("Comprimento das strings são: "+ (word1.length()+ word2.length()+word3.length()));

    }

}
