package aula7.ex1;

import javax.swing.JOptionPane;

public class TesteAtribuicao{

    public static void main(String[] args) {
        
        String nome = JOptionPane.showInputDialog("Nome do professor:");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade:"));

        Professor professor = new Professor(nome, idade);

        String nomedisc = JOptionPane.showInputDialog("Nome da disciplina:");
        boolean pratico = Boolean.parseBoolean(JOptionPane.showInputDialog("Pratica? (true/false):"));
        Disciplina disciplina = new Disciplina (nomedisc, pratico);

        Atribuicao atribuicao = new Atribuicao(professor, disciplina);
    

        JOptionPane.showMessageDialog(null, atribuicao.getDados());

    }

}
