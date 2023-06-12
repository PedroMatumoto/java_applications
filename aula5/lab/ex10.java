package aula5.lab;

import java.util.*;

public class ex10 {
    public static void main(String[] args) {
        int codigo =-1;
        double total =0;
        double total1 = 0;
        double total2 = 0;
        double total3 = 0;
        while (codigo!=0){
        Scanner sn = new Scanner(System.in);
        System.out.println("Codigo do consumidor:");
        codigo = sn.nextInt();
        if (codigo==0){

        }else{
            System.out.println("Quantidade kWh consumidos:");
            double quant = sn.nextDouble();

            System.out.println("Tipo do consumidor:");
            int tipo = sn.nextInt();

        
            if (tipo == 1) {
                total = 0.3 * quant;
                total1+=total;
    
            }
            if (tipo == 2) {
                total = 0.5 * quant;
                total2 +=total;
                
            }
            if (tipo == 3) {
                total = 0.7 * quant;
                total3 +=total;
                
            }
            System.out.println("Total a pagar: " + total + " reais\n");
            System.out.println("Total para o tipo 1: "+total1+"\n"+ "Total para o tipo 2: " + total2 + "\n"+ "Total para o tipo 3: "
                    + total3 + "\n");
            System.out.println("Média de consumo entre 1 e 2: " +(total1+total2)/2);
        }


    

    }
}
}
