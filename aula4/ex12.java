

import javax.swing.JOptionPane;

public class ex12 {
    public static void main(String[] args) {
        String n1 = JOptionPane.showInputDialog(null, "Número : ");
        int n1_n = Integer.parseInt(n1);

        if (n1_n % 2 == 0)
            JOptionPane.showMessageDialog(null, "É divisível por 2");
        if (n1_n % 5 == 0)
            JOptionPane.showMessageDialog(null, "É divisível por 5");
        if (n1_n % 10 == 0)
            JOptionPane.showMessageDialog(null, "É divisível por 10");

        else 
            JOptionPane.showMessageDialog(null, "Não é divisivel por 2,5 ou 10");
    }

}
