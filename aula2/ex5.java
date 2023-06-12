package aula2;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class ex5 {

    public static void main(String args[]) {
        float height;
        float weight;
        Scanner read = new Scanner(System.in);

        System.out.printf("Weight: \n");
        height = read.nextFloat();
        read.nextLine();

        System.out.printf("Height: \n");
        weight = read.nextFloat();
        read.nextLine();

        

        if (height < 1 || weight<1) {
            System.out.printf("Data typed incorrectly \n");
        }

        System.out.printf("Your typed data is " + weight + "kg " + "and " + height+"m");

    }

}
