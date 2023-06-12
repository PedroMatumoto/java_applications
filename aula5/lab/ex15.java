package aula5.lab;
import javax.swing.JOptionPane;

public class ex15 {
    public static void main(String[] args) {
        String limite = JOptionPane.showInputDialog("Limite: ");
        int lim = Integer.parseInt(limite);
        int i=1;
        int j =0;
        int soma=0;
        System.out.print(j + " " + i);
        do{
            soma = i + j;
            j = i;
            i = soma;
            System.out.print(" " + soma);
        }
        while (soma<(lim-j));
    }
    
}
