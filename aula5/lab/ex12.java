package aula5.lab;

import javax.swing.JOptionPane;

public class ex12 {
    public static void main(String[] args) {
        int i = 2;
        int primo=0;

        String numero = JOptionPane.showInputDialog("Numero");
        int num = Integer.parseInt(numero);

        while (i < num) {
            if(num%i==0){
                primo++;
            }
            i++;
        }

        if(primo!=0){
            System.out.println("Não é primo");
        }
        else System.out.println("É primo");
    }

   
}
