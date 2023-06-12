package aula3;

import javax.swing.JOptionPane;

public class ex11 {
    public static void main(String[] args) {
        String frase1 = JOptionPane.showInputDialog("Digite a frase 1:");
        int tam1=frase1.length();
        String frase2 = JOptionPane.showInputDialog("Digite a frase 2:");
        int tam2 = frase2.length();
        String frase3 = JOptionPane.showInputDialog("Digite a frase 3:");
        int tam3 = frase3.length();
        char[] f1 = frase1.toCharArray();
        char[] f2 = frase2.toCharArray();
        char[] f3 = frase3.toCharArray();

        String f1_pm = "";
        String f1_sm = "";
        String f2_pm = "";
        String f2_sm = "";
        String f3_pm = "";
        String f3_sm = "";

        for(int i=0;i<tam1/2;i++){
            f1_pm=f1_pm+f1[i];
        }

        for(int i=0;tam1/2<i;i++){
            f1_sm=f1_sm+f1[i];
        }

        for(int i=0;i<tam2/2;i++){
            f2_pm=f2_pm+f2[i];
        }

        for(int i=0;tam2/2<i;i++){
            f2_sm=f2_sm+f2[i];
        }

        for(int i=0;i<tam3/2;i++){
            f3_pm=f3_pm+f3[i];
        }

        for(int i=0;tam3/2<i;i++){
            f3_sm=f3_sm+f3[i];
        }



        JOptionPane.showMessageDialog(null, "" + f2_pm+f3_sm+f2_sm+f1_pm+f3_pm+f1_sm);


    }
    
}
