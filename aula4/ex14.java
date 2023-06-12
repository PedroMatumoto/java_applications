

import javax.swing.JOptionPane;

public class ex14 {
    public static void main(String[] args) {
        String n1 = JOptionPane.showInputDialog(null, "Número : ");
        int n1_n = Integer.parseInt(n1);

        int milhar =n1_n/1000;
        int centena = (n1_n%1000)/10;

        int multi = milhar * centena;

        String saida = (multi %4 == 0 ? "Multiplo de 4!" : "Não multiplo de 4!");

        

        JOptionPane.showMessageDialog(null, saida);
    }


    
}
