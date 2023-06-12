package aula6.ExTurma;

import javax.swing.JOptionPane;

public class testeturma {

    public static void main(String[] args) {
        String nome = JOptionPane.showInputDialog("Nome:");
        String curso = JOptionPane.showInputDialog("Curso:");
        int quantidadedeAlunos = Integer.parseInt(JOptionPane.showInputDialog("Quantidade"));
        int serie = Integer.parseInt(JOptionPane.showInputDialog("Serie:"));

        Turma turma = new Turma(nome, curso, quantidadedeAlunos, serie);

        String msg = "Nome: " + turma.getNome() + "\nCurso: " + turma.getCurso()  + "\nQuantidade de alunos: "
                + turma.getQuantidade()
                + " alunos" + "\nSerie: " + turma.getSerie();

        JOptionPane.showMessageDialog(null, msg);

        quantidadedeAlunos = Integer.parseInt(JOptionPane.showInputDialog("Quantidade"));
        turma.setQuantidade(quantidadedeAlunos);

        msg = "Nome: " + turma.getNome() + "\nCurso: " + turma.getCurso() + "\nQuantidade de alunos: "
                + turma.getQuantidade()
                + " alunos"+"\nSerie: "+turma.getSerie();

        JOptionPane.showMessageDialog(null, msg);

    }

}
