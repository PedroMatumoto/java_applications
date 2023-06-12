package aula3;

import javax.swing.JOptionPane;

public class ex19 {

    public static void main(String[] args) {
        String sd_mai= JOptionPane.showInputDialog("Diagonal Maior:");
        double d_mai = Double.parseDouble(sd_mai);

        String sd_men = JOptionPane.showInputDialog("Diagonal Menor:");
        double d_men = Double.parseDouble(sd_men);

        double area = (d_mai * d_men) / 2;
        JOptionPane.showMessageDialog(null, "Área: " + area);

    }

}
