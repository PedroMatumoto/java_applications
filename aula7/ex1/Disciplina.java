package aula7.ex1;

import javax.swing.JOptionPane;

public class Disciplina {
    private String nome;
    private boolean pratica;

    public Disciplina(String name, boolean pratic) {
        nome = name;
        pratica= pratic;
    }

    public String getNomeDisciplina() {
        return nome;
    }

    public boolean getPratica() {
        return pratica;
    }

    // Modificadores

    public void setNome(String name) {
        nome = name;
    }

    public void setPratica(boolean pratic) {
        pratica = pratic;
    }

    public String getDisciplina() {
        return "Disciplina [nome=" + nome + ", pratica=" + pratica+ "]";
    }

}
