package aula10.PessoaFis;

public class Tarefeiro extends Empregado {
    private double s_tarefas=59.90;
    private int tarefas;

    public Tarefeiro(String nome, String sobrenome, String cpf, double salario,int tarefas) {
        super(nome, sobrenome, cpf, salario);
        this.tarefas=tarefas;

    }

    public double getSalario() {
        return super.getSalario()+(s_tarefas*tarefas);
    }

}
