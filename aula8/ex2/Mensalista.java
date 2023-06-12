package aula8.ex2;

public class Mensalista extends Empregado {
    private int meses;
    private double valormes=80;

    public Mensalista(String nome, String sobrenome, String cpf, double salario, int meses){
    super(nome, sobrenome, cpf, salario);
    this.meses=meses;
    }

    public double getSalario(){
        return super.getSalario()+valormes*meses;
    }
    
}
