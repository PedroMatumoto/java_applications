package aula3;

import javax.swing.JOptionPane;

public class ex14 {
    public static void main(String[] args) {
        String a = JOptionPane.showInputDialog("a:");
        double num_a= Double.parseDouble(a);
        String b = JOptionPane.showInputDialog("b:");
        double num_b= Double.parseDouble(b);
        String c = JOptionPane.showInputDialog("c:");
        double num_c= Double.parseDouble(c);
        JOptionPane.showMessageDialog(null, "Resultado da expressão(x): " + (2*((num_a-num_c)/8)-num_b*5));

    }

}
