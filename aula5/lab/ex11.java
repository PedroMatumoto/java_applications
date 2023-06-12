package aula5.lab;

import javax.swing.JOptionPane;

public class ex11 {
    public static void main(String[] args) {
        int idade=0;
        int cont21=0;
        int cont50 = 0;
        do{
            
            String id = JOptionPane.showInputDialog("Idade:");
            idade = Integer.parseInt(id);
            if(idade<20&&idade>0&&idade<120){
                cont21++;
            }
            if (idade > 50 && idade > 0 && idade < 120) {
                cont50++;
            }
        }
        while(idade>0&&idade<120);
        System.out.println("Numero de pessoas com menos de 20: "+cont21+"\nNúmero de pessoas com mais de 50 anos: "+cont50);
    }
    
}
