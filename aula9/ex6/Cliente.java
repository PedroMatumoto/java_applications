package aula9.ex6;

public class Cliente {
    private String nome;
    private String telefone;
    private int id;

    public Cliente(String nome, String telefone, int id) {
        this.nome = nome;
        this.telefone = telefone;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        if(telefone.length()==9){
            this.telefone = telefone;
        }
        else{
            System.out.println("Telefone inválido!");
        }
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
