package aula3;

import javax.swing.JOptionPane;

public class ex12 {
    public static void main(String[] args) {
        String completo = JOptionPane.showInputDialog("Digite a data em formato:");
        char[] separado = completo.toCharArray();
        JOptionPane.showMessageDialog(null, "Dia:" + separado[0] +separado[1]+"\n" + "Mês:" + separado[2]+ separado[3] + "\n" + "Ano:" + separado[4]+ separado[5]);

    }

}
