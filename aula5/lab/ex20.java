package aula5.lab;

import javax.swing.JOptionPane;

public class ex20 {
    public static void main(String[] args) {

        String nome = "";
        String conjunto = "";
        String idade;
        String sexo;

        String fim = "pare";

        do {
            nome = JOptionPane.showInputDialog("Nome:");

            idade = JOptionPane.showInputDialog("Idade:");
            int id=Integer.parseInt(idade);
            sexo = JOptionPane.showInputDialog("Sexo:");

            if ((sexo.equals("masculino")&&id>21)==true) {
                System.out.println(nome);
            } 
        } while (nome.equals(fim) != true);

    }
}
