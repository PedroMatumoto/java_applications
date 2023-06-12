package aula2;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class ex1_mode2 {

    public static void main(String args[]) {
        String c;
        String palavra_ant = "";
        String vazio=" ";
        Scanner read = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.printf("Palavra: \n");
            c = read.next();
            palavra_ant = palavra_ant.concat(c);
            palavra_ant = palavra_ant.concat(vazio);
            read.nextLine();
        }
        System.out.printf(palavra_ant);

    }

}
