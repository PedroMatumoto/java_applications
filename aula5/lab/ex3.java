package aula5.lab;

import javax.swing.JOptionPane;

public class ex3 {
    public static void main(String[] args) {

        double num = 0;

        double i = 0;
        do {

            String numero = JOptionPane.showInputDialog("Numero");
            num = Double.parseDouble(numero);
            if (num > 100 && num<200) {
                i++;
            }
        } while (num != 0);

        System.out.println(i + " vezes");
        // 13n +25
    }
}
