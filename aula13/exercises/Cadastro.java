package aula13.exercises;

public class Cadastro {
    private String nomeusuario;
    private String senha;

    public Cadastro() {
        clearObject();
    }

    public Cadastro(String nomeusuario, String senha) {
        this.nomeusuario = nomeusuario;
        this.senha = senha;
    }

    public String getNomeusuario() {
        return nomeusuario;
    }

    public void setNomeusuario(String nomeusuario) {
        if (nomeusuario.length() > 0) {
            this.nomeusuario = nomeusuario;
        } else {
            this.nomeusuario = "Nome inválido";
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha.length() > 0) {
            this.senha = senha;
        } else {
            this.senha = "Senha inválida";
        }
    }

    public void clearObject() {
        this.nomeusuario = "";
        this.senha = "";
    }

    @Override
    public String toString() {
        return "Cadastro [nomeusuario=" + nomeusuario + ", senha=" + senha + "]";
    }
    
}
