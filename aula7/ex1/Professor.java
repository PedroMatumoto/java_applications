package aula7.ex1;

import javax.swing.JOptionPane;

public class Professor{
    private String nome;
    private int idade;

    public Professor(String name, int age) {
        nome = name;
        idade = age;
    }

    public String getNomeProfessor() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    // Modificadores

    public void setNome(String name) {
        nome = name;
    }

    public void setIdade(int age) {
        idade = age;
    }
    
    public String getProfessor(){
        return "Professor [nome="+nome+", idade="+idade+"]";
    }

}
