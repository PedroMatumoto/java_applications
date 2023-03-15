package aula2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ex5 {
    public static void main(String[] args) throws FileNotFoundException{
        File file = new File("/Users/pedro/OneDrive/Área de Trabalho/teste.txt");
        Scanner scan = new Scanner(file);
        String[] stringarray = new String[3];
        int i=0;

        while(i<3){
            stringarray[i]=scan.nextLine();
            i++;
        }

        System.out.println(stringarray[2]+" "+ stringarray[1]+ " " + stringarray[0]);
        
    }
    
}
