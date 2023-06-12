

import javax.swing.JOptionPane;

public class ex13 {
    public static void main(String[] args) {
        String n1 = JOptionPane.showInputDialog(null, "Número : ");
        int n1_n = Integer.parseInt(n1);

        String saida = (((n1_n%100)/10)%2==0? "Par!" : "Impar!");
        JOptionPane.showMessageDialog(null, saida);
        
        

    }
    
}
