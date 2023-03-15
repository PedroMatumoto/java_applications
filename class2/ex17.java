package aula2;

import javax.swing.JOptionPane;

public class ex17 {
    public static void main(String[] args) {
        String s_n = JOptionPane.showInputDialog("Numero:");
        int n = Integer.parseInt(s_n);
       
        JOptionPane.showMessageDialog(null, "Quadrado: "+Math.pow(n, 2)+"\n"+"Raiz: "+Math.sqrt(n));

    }

}
