
import javax.swing.JOptionPane;

public class ex15 {
    public static void main(String[] args) {
        String n1 = JOptionPane.showInputDialog(null, "Ano de nascimento: ");
        int n1_n = Integer.parseInt(n1);

        String n2 = JOptionPane.showInputDialog(null, "Ano atual: ");
        int n2_n = Integer.parseInt(n2);

        if(n1_n <0 || n2_n<0|| n1_n < 2023 || n2_n < 2023) 
            JOptionPane.showMessageDialog(null, "Ano inválido" );


        else JOptionPane.showMessageDialog(null,"Sua idade é de" + (n2_n-n1_n)+" anos");





    }

    
}
