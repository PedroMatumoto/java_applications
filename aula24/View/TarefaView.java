package View;
import java.util.List;


import Model.TarefaModel;

public class TarefaView {
    public String exibirTarefas(List<TarefaModel> tarefas) {
        String msg ="<html>";
        msg += "Tarefas:"+"\n"+"<br>";
        for (TarefaModel tarefa : tarefas) {
            String status = tarefa.isConcluida() ? "[X]" : "[ ]";
            msg += (status+ " " +tarefa.getDescricao()+ "<br>");
        }
        msg += "</html>";
        return msg;
    }

    public void exibirTarefa(TarefaModel tarefa) {
        System.out.println("Tarefa:");
        System.out.println(tarefa.getDescricao());
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
    
}
