package aula10.PessoaFis;

public class Horista extends Empregado {
    private double s_hora= 50;
    private double horas;

    public Horista(String nome,String sobrenome,String cpf, double salario, double horas) {
        super(nome, sobrenome, cpf, salario);
        this.horas= horas;
    }

    public double getSalario() {
        return  super.getSalario()+(horas*s_hora);
    }


}
