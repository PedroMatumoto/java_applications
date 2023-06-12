package aula5.lab;

import javax.swing.JOptionPane;

public class ex5 {
    public static void main(String[] args) {

        String nome="";
        String conjunto="";


        do {
            nome = JOptionPane.showInputDialog("Numero:");
            double num =Double.parseDouble(nome);
            
            if(nome.equals("-999")){

            }else 
                conjunto = conjunto.concat(num+" "+"Raiz: "+Math.sqrt(num)+" "+ "Inverso: " +1/num + "\n");
        } while (nome.equals("-999")!=true);
        

        System.out.println(conjunto);

        // 13n +25
    }
}
