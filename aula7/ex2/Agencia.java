package aula7.ex2;
import javax.swing.JOptionPane;

public class Agencia {
    private String nome;
    private int digito;
    private int numero;

    public Agencia(String name, int digit, int number) {
        nome = name;
        digito=digit;
        numero=number;

    }

    public String getNomeAgencia() {
        return nome;
    }

    public int getDigito() {
        return digito;
    }

    public int getNumero() {
        return numero;
    }

    // Modificadores

    public void setNomeAgencia(String name) {
        nome = name;
    }

    public void setDigito(int age) {
        idade = age;
    }

    public String getProfessor() {
        return "Professor [nome=" + nome + ", idade=" + idade + "]";
    }

}
