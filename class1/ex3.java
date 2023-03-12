package aula1;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class ex3 {

    public static void main(String args[]) {
        int num1;
        Scanner read = new Scanner(System.in);

        System.out.printf("Type a number: \n");
        num1 = read.nextInt();
        read.nextLine();

        

        System.out.println("Value of the typed number is"+" "+num1);

    }

}
