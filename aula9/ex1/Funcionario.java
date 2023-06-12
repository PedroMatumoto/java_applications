package aula9.ex1;


public class Funcionario extends Pessoa {
    private String cargo;
    private int categoria;
    private double salario;;
    
    public Funcionario(String nome,int idade, double salario,String cargo){
        super(nome,idade);
        this.salario=salario*(categoria()+100)/100;
        this.categoria=categoria();
        this.cargo=cargo;
    }

    public String getDados(){
        String msg = super.getDados()+"\nSalario: "+getSalario()+ "\nCargo: " + getCargo() +"\nCategoria: "+categoria();
        return msg;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo){
        this.cargo=cargo;
    }

    public int categoria(){
        if(getIdade()>20) return 30;
        else return 10;
    }

    public double getSalario() {
        return salario;
    }

    public double salario() {
       return 0.0;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

}
