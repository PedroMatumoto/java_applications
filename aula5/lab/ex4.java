package aula5.lab;

import javax.swing.JOptionPane;

public class ex4 {
    public static void main(String[] args) {

        String nome="";
        String conjunto="";

        String fim="FIM";


        do {
            nome = JOptionPane.showInputDialog("Nome:");
            if(nome.equals(fim) == true){

            }else 
                conjunto = conjunto.concat(nome + "\n");
        } while (nome.equals(fim)!=true);
        

        System.out.println(conjunto);

        // 13n +25
    }
}
