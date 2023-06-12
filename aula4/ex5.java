

import javax.swing.JOptionPane;

public class ex5 {
    public static void main(String[] args) {
        String valor1 = JOptionPane.showInputDialog("Número:");
        int v1 = Integer.parseInt(valor1); 

        if(v1>20&&v1<90) JOptionPane.showInputDialog(null, "Compreendido entre 20 e 90");
        else JOptionPane.showInputDialog(null,"Não está compreendido entre 20 e 90");
    }

    
}
