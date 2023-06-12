package aula3;

import javax.swing.JOptionPane;

public class ex1 {
    public static void main(String[] args){
        String s_anos= JOptionPane.showInputDialog("Digite sua idade:");
        double anos =Double.parseDouble(s_anos);
        double dias_v=anos*365;
        JOptionPane.showMessageDialog(null, "Dias vividos: "+dias_v);


    }
    
}
