package aula2;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class ex7 {

    public static void main(String args[]) {
        char milhar;
        char centena;
        char dezena;
        char unidade;
        Scanner read = new Scanner(System.in);

        
        System.out.printf("Milhar: \n");
        milhar = read.next().charAt(0);
        read.nextLine();

        System.out.printf("Centena: \n");
        centena = read.next().charAt(0);;
        read.nextLine();

        System.out.printf("Dezena: \n");
        dezena = read.next().charAt(0);
        read.nextLine();

        System.out.printf("Unidade: \n");
        unidade = read.next().charAt(0);
        read.nextLine();

        String num;

        num=""+milhar+centena+dezena+unidade;

        System.out.println("String:"+num);
    }

}
