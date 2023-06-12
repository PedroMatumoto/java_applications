

import javax.swing.JOptionPane;

public class ex1 {
    public static void main(String[] args) {
        String valor1=JOptionPane.showInputDialog("Primeiro valor:");
        int v1=Integer.parseInt(valor1);
        String valor2 = JOptionPane.showInputDialog("Segundo valor:");
        int v2 = Integer.parseInt(valor2);

        int soma=v1+v2;

        if(soma>10){
            JOptionPane.showMessageDialog(null,"Soma: "+soma);
        }

    }
    
}
