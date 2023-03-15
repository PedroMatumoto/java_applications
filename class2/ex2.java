package aula2;

import javax.swing.JOptionPane;

public class ex2 {

    public static void main(String[] args) {
        String s_base = JOptionPane.showInputDialog("Digite a base:");
        double base = Double.parseDouble(s_base);

        String s_altura = JOptionPane.showInputDialog("Digite o comprimento:");
        double altura = Double.parseDouble(s_altura);

        double area = (base*altura);
        JOptionPane.showMessageDialog(null, "Área: " + area);

    }
    
}
