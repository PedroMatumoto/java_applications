package Model;
public class TarefaModel {
    private String descricao;
    private boolean concluida;

    public TarefaModel(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void marcarComoConcluida() {
        this.concluida = true;
    }

    public void desmarcarComoConcluida() {
        this.concluida = false;
    }


    
}
