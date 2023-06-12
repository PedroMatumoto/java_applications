

import javax.swing.JOptionPane;

public class ex7 {
    public static void main(String[] args) {
        String nome = JOptionPane.showInputDialog("Nome: ");
        char sexo = JOptionPane.showInputDialog("Sexo: ").charAt(0);
        String idade = JOptionPane.showInputDialog(null, "Idade: ");
        int idade_n= Integer.parseInt(idade);
        String saida=(idade_n>25&&sexo=='F'||sexo=='f'?"Aceita!":"Não aceita!");
        JOptionPane.showMessageDialog(null, saida);
    }
    
}
