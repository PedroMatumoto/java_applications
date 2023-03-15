package aula2;

import javax.swing.JOptionPane;

public class ex10 {

    public static void main(String[] args) {
        String log=JOptionPane.showInputDialog("Digite o número:");
        String base = JOptionPane.showInputDialog("Digite a base:");

        double log_d=Double.parseDouble(log);
        double base_d = Double.parseDouble(base);
        
        JOptionPane.showMessageDialog(null, "O logaritmo nesta base é: "+ Math.log(log_d)/Math.log(base_d));
    }
    
}
