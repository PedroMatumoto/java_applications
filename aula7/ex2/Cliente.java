package aula7.ex2;
import javax.swing.JOptionPane;

public class Cliente {
    private String nome;
    private String CPF;
    private ContaCorrente contacorrente;

    public Cliente(String name, int digit) {
        nome = name;
        digito=digit;
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

    public String getProfessor() {
        return "Professor [nome=" + nome + ", idade=" + idade + "]";
    }

}
