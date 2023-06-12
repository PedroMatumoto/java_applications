package aula5.lab;
import java.util.*;

public class ex14 {
    public static void main(String[] args) {
        int numero = 0;
        int ant = -1;
        int maior=0;
        while (numero!=-9999){
        System.out.println("Digite o numero:");
        Scanner sn = new Scanner(System.in);
        numero = sn.nextInt();
        if(numero>ant){
            maior = numero;
            ant = numero;

        }

        }
        System.out.println("O maior número digitado foi: " + maior);


    }
    
}
