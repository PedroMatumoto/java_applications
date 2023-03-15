package aula2;

import javax.swing.JOptionPane;

public class ex6 {
    public static void main(String[] args) {
        String inicial = JOptionPane.showInputDialog("Digite o valor da dívida inicial:");
        String juros = JOptionPane.showInputDialog("Qual a taxa de juros?:");
        String meses = JOptionPane.showInputDialog("Quanto tempo até pagar?:");

        double inicial_num=Double.parseDouble(inicial);
        double juros_num = Double.parseDouble(juros);
        double meses_num = Double.parseDouble(meses);

        double segunda_metade=Math.pow((1+juros_num)/100, meses_num);

        JOptionPane.showMessageDialog(null,"Valor final da dívida é: "+inicial_num*segunda_metade);
    }
}
