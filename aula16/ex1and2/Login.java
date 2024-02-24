package aula16.ex1and2;

public class Login {

    private String nome;
    private String senha;

    public Login() {
        this.nome = "admin";
        this.senha = "admin";
    }

    public Login(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return this.nome;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

}
