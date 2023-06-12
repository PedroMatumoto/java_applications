package aula3;

import javax.swing.JOptionPane;

public class ex15 {
    public static void main(String[] args) {
        String Raio = JOptionPane.showInputDialog("Raio:");
        double raio = Double.parseDouble(Raio);
        double pi= 3.14159;
        JOptionPane.showMessageDialog(null, "A área do círculo é: " + pi*raio*raio);

    }

}
