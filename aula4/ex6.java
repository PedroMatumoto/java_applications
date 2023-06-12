
import javax.swing.JOptionPane;

public class ex6 {
    public static void main(String[] args) {
        String valor1 = JOptionPane.showInputDialog("Número:");
        int v1 = Integer.parseInt(valor1);

        if (v1 > 20)
            JOptionPane.showMessageDialog(null, "Maior que 20");
        else if(v1==20)
            JOptionPane.showMessageDialog(null, "Igual a 20");
        else 
            JOptionPane.showMessageDialog(null, "Menor que 20");
    } 
    
}
