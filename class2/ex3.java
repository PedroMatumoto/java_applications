package aula2;
import javax.swing.JOptionPane;

public class ex3 {
    public static void main (String[] args){
        String s_num= JOptionPane.showInputDialog("Digite o número:");
        double numero= Double.parseDouble(s_num);
        JOptionPane.showMessageDialog(null, "O número elevado ao quadrado é: "+Math.pow(numero, 2));
    }
    
}
