package aula2;

import javax.swing.JOptionPane;

public class ex9 {
    public static void main(String[] args) {
        String log_s = JOptionPane.showInputDialog("Digite o número: ");
        double log= Double.parseDouble(log_s);
        
        JOptionPane.showMessageDialog(null, "Logaritmo na base 10: " + Math.log10(log));

    }
    
}
