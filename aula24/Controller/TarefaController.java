package Controller;
import java.util.List;

import Model.TarefaModel;
import View.TarefaView;

import java.util.ArrayList;

public class TarefaController {
    private List<TarefaModel> tarefas= new ArrayList<>();
    private TarefaView view = new TarefaView();

    public void adicionarTarefa(String descricao) {
        TarefaModel tarefa = new TarefaModel(descricao);
        tarefas.add(tarefa);
        view.exibirMensagem("Tarefa adicionada com sucesso!");
    }

    public void removerTarefa(int indice) {
        tarefas.remove(indice);
    }

    public void marcarTarefaComoConcluida(int indice) {
        if(indice >= 0 && indice < tarefas.size()) {
            tarefas.get(indice).marcarComoConcluida();
        } 
    }

    public void desmarcarTarefaComoConcluida(int indice) {
        if(indice >= 0 && indice < tarefas.size()) {
            tarefas.get(indice).desmarcarComoConcluida();
        } 
    }

    public String atualizarView() {
        
        return view.exibirTarefas(tarefas);
    }
    
}
