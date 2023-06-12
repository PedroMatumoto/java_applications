package aula6.ExTurma;

import javax.swing.JOptionPane;

public class Turma {
    private String nome;
    private String curso;
    private int quantidadedeAlunos;
    private int serie;

    public Turma(String name, String course, int quantalunos, int year) {
        this.nome = name;
        this.curso = course;
        this.quantidadedeAlunos = quantalunos;
        this.serie = year;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public int getQuantidade() {
        return quantidadedeAlunos;
    }

    public int getSerie() {
        return serie;
    }


    // Modificadores


    public void setNome(String name) {
        nome = name;
    }

    public void setCurso(String course ) {
        curso = course;
    }

    public void setQuantidade(int quantalunos) {
       quantidadedeAlunos=quantalunos;
    }

    public void setSerie(int year) {
        serie=year;
    }

}
