package aula8.ex2;

public class PessoaFisica {
    private String nome;
    private String sobrenome;
    private String cpf;

    public PessoaFisica(){
        nome="Vanessa";
        sobrenome="Soares";
        cpf="12345678901";
        
    }

    public PessoaFisica(String nome,String sobrenome,String cpf){
        this.nome=nome;
        this.sobrenome=sobrenome;
        this.cpf=cpf;
    }

    public String getNome(){
        return nome;
    }

    public String getcpf() {
        return cpf;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome=sobrenome;
    }

    public void setcpf(String cpf) {
        this.cpf=cpf;
    }
    
    public String Dados(){
        String msg= "NomePF: "+getNome()+"\nSobrenomePF: "+getSobrenome()+"\nCPF: "+getcpf()+"";
        return msg;
    }
}
