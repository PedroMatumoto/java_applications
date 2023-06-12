package aula8.ex2;

public class Empregado extends PessoaFisica {
    private double salario;
    public Empregado(String nome, String sobrenome, String cpf,double salario){
        super(nome, sobrenome, cpf);
        this.salario=salario;
    }
    

    public double getSalario() {
        return salario;
    }
    
    public double salario(){
        return 0.0;
    }

    



    @Override
    public String Dados(){
        String msg = super.Dados()+ "\nEmpregado: "+ "\nSalario: "+getSalario();
        return msg;
    }
}

