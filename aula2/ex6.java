package aula2;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class ex6 {

    public static void main(String args[]) {
        String c;
        String palavra_ant="";
        Scanner read = new Scanner(System.in);
        for(int i=0;i<10;i++){
        System.out.printf("Char: \n");
        c = read.next();
        palavra_ant=palavra_ant.concat(c);
        read.nextLine();
        }
        System.out.printf(palavra_ant);


    }

}
