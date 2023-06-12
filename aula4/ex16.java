

import javax.swing.JOptionPane;

public class ex16 {
    public static void main(String[] args) {
        String n1 = JOptionPane.showInputDialog(null, "Número 1: ");
        int n1_n = Integer.parseInt(n1);
        String n2 = JOptionPane.showInputDialog(null, "Número 2: ");
        int n2_n = Integer.parseInt(n2);

        if (n1_n == n2_n)
            JOptionPane.showMessageDialog(null,"Iguais");

        else 
            JOptionPane.showMessageDialog(null, "Diferentes");
    }
    
    
}
