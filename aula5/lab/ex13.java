package aula5.lab;

import javax.swing.JOptionPane;

public class ex13 {
    public static void main(String[] args) {
        int i = 2;
        int primo = 0;
        int num = 15;
        int contador = 0;

        while (num > 0) {

            String numero = JOptionPane.showInputDialog("Numero");
            num = Integer.parseInt(numero);
            primo = 0;
            i = 2;

            while (i < num) {
                if (num % i == 0) {
                    primo++;
                }
                i++;
            }
            if (primo != 0) {
            } else if (primo == 0) {
                contador++;
            }
        }
        System.out.println("Numeros primos digitados: " + (contador-1));

    }

}
