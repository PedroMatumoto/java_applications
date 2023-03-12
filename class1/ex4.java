package aula1;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class ex4 {

    public static void main(String args[]) {
        int day;
        int month;
        int year;
        Scanner read = new Scanner(System.in);

        System.out.printf("Day: \n");
        day = read.nextInt();
        read.nextLine();

        System.out.printf("Month: \n");
        month = read.nextInt();
        read.nextLine();

        System.out.printf("Year: \n");
        year = read.nextInt();
        read.nextLine();

        if(day<1 || day>31){
            System.out.printf("Data typed incorrectly \n");
        }

        if (month < 1 || month > 12) {
            System.out.printf("Data typed incorrectly \n");
        }

        if (year < 1) {
            System.out.printf("Data typed incorrectly \n");
        }


        System.out.printf(day + "/" + month + "/" + year);

    }

}
