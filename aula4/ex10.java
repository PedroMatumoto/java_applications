

import javax.swing.JOptionPane;

public class ex10 {
    public static void main(String[] args) {
        String n1 = JOptionPane.showInputDialog(null, "Número : ");
        int n1_n = Integer.parseInt(n1);
        if (n1_n % 5 == 0)
            JOptionPane.showMessageDialog(null, "É divisível");
        else
            JOptionPane.showMessageDialog(null, "Não é divisível");
    }
    
}
