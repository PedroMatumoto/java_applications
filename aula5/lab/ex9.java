package aula5.lab;

import javax.swing.JOptionPane;

public class ex9 {
    public static void main(String[] args) {

        String nome = "";
        String conjunto = "";

        do {
            nome = JOptionPane.showInputDialog("Numero:");
            double num = Double.parseDouble(nome);
            System.out.println("Divisores:");
            for (double i = num; i > 0; i--) {
                if (num % i == 0) {
                    System.out.println(i);
                }
            }
            System.out.println("\n");
            
            

            if (nome.equals("-999")) {

            } else
                conjunto = conjunto.concat(num + "\n");
        } while (nome.equals("-999") != true);

        System.out.println(conjunto);

        // 13n +25
    }
}
