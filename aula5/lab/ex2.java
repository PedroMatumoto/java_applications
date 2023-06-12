package aula5.lab;

import javax.swing.JOptionPane;

public class ex2 {
    public static void main(String[] args) {

        double num =0;

        double i=0;

        double soma = 0;
        do{

        String numero = JOptionPane.showInputDialog("Numero");
        num = Double.parseDouble(numero);
        if (num>0){
            soma=num+soma;
            i++;
        }
        }
        while(num>=0);


        System.out.println(soma/i);
        // 13n +25
    }
}
