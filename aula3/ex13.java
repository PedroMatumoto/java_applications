package aula3;

import javax.swing.JOptionPane;

public class ex13 {
    public static void main(String[] args) {
        String completo = JOptionPane.showInputDialog("Digite a data em formato:");
        String[] parts = completo.split("/");
        String dia = parts[0];
        String mes = parts[1];
        String ano = parts[2];
        JOptionPane.showMessageDialog(null, "Dia: " + dia + "\n" + "Mês: " + mes + "\n" + "Ano: " +ano);

    }

}
