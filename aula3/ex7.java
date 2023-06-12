package aula3;

import javax.swing.JOptionPane;

public class ex7 {
    public static void main(String[] args) {
        String numero_s = JOptionPane.showInputDialog("Digite um número inteiro com 5 digitos:");
        int numero = Integer.parseInt(numero_s);
        int dezena = (numero % 100)/10;
        JOptionPane.showMessageDialog(null, "Dezena: "+dezena);
    }
    
    
}
