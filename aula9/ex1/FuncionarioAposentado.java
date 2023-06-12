package aula9.ex1;

public class FuncionarioAposentado extends Funcionario{
    private double salarioAposentadoria;

    public FuncionarioAposentado(String nome,int idade, double salario,String cargo){
        super(nome,idade,salario,cargo);
    }

    public double getSalarioAposentadoria() {
        salarioAposentadoria = getSalario() * 0.8;
        return salarioAposentadoria;
    }

    public void setSalarioposentadoria(double salarioAposentadoria) {
        this.salarioAposentadoria=salarioAposentadoria;
    }

    @Override
    public String getDados() {
        String msg = super.getDados() + "\nAposentadoria: " + getSalarioAposentadoria();
        return msg;
    }

}
