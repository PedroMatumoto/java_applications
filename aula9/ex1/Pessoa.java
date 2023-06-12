package aula9.ex1;

public class Pessoa {
    private String nome;
    private int idade;
    private double salario;
    private String cargo;

    public Pessoa(){
        nome="Ana";
        idade=20;
        salario=0.0;
        cargo = "Desempregado";
        
    }

    public Pessoa(String nome,int idade){
        this.nome=nome;
        this.idade=idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    
    public String getDados(){
        String msg="Pessoa: "+"\nNome: "+getNome()+"\nIdade: "+getIdade();
        return msg;
    }

}
