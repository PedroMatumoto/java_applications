package aula3;

import javax.swing.JOptionPane;

public class ex16 {
    public static void main(String[] args) {
        String s_n = JOptionPane.showInputDialog("Numerador:");
        int n = Integer.parseInt(s_n);
        String s_d = JOptionPane.showInputDialog("Denominador:");
        int d = Integer.parseInt(s_d);
        JOptionPane.showMessageDialog(null, "Dividendo: "+n+"\n"+ "Divisor: " + d + "\n"+ "Quociente: " + n/d
                + "\n"+ "Resto: " + n%d + "\n");

    }

}
