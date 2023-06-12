
import javax.swing.JOptionPane;

public class ex3 {
    public static void main(String[] args) {
        String valor1 = JOptionPane.showInputDialog("Número:");
        int v1 = Integer.parseInt(valor1);

        if (v1 < 0) {
            JOptionPane.showMessageDialog(null, Math.pow(v1, 2));
        }
        if (v1 > 0) {
            JOptionPane.showMessageDialog(null, Math.sqrt(v1));
        }


    }

}
