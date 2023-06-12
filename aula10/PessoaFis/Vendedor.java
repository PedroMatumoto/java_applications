package aula10.PessoaFis;

public class Vendedor extends Empregado {
    private double p_comissao=0.3;
    private double v_vendas;

    public Vendedor(String nome, String sobrenome, String cpf, double salario, double v_vendas) {
        super(nome, sobrenome, cpf, salario);
        this.v_vendas=v_vendas;
    }

    public double getSalario() {
        return super.getSalario() + (p_comissao * v_vendas);
    }

}
