package aula1;

import java.net.SocketTimeoutException;

import javax.swing.*;

public class ex5_modeswing {

    public static void main(String args[]) {
        String height = JOptionPane.showInputDialog("Digite a altura:");
        String weight = JOptionPane.showInputDialog("Digite o peso:");
        Double.parseDouble(height);
        Double.parseDouble(weight);
        JOptionPane.showMessageDialog(null, "Seus dados digitados foram: " + weight + "kg " + "e " + height + "m");
    }

}
