package aula9.ex5;

import java.util.ArrayList;

public class Deposito {
    private ArrayList<Caixa> caixas;

    public Deposito() {
        caixas = new ArrayList<>();
    }

    public void adicionarCaixa(Caixa caixa) {
        caixas.add(caixa);
    }

    public boolean removerCaixa(String dono) {
        for (int i = 0; i < caixas.size(); i++) {
            if (caixas.get(i).getDono().equals(dono)) {
                caixas.remove(i);
                return true;
            }
        }
        return false;
    }

    public void ListarCaixas() {
        for (int i = 0; i < caixas.size(); i++) {
            System.out.println("Caixa " + i + ": ");
            System.out.println("Dono: " + caixas.get(i).getDono());
            System.out.println("Corredor: " + caixas.get(i).getCorredor());
            System.out.println("Posição: " + caixas.get(i).getPosicao());
            System.out.println("Peso: " + caixas.get(i).getPeso());
        }
    }

    public int encontrarCaixa(String dono) {
        for (int i = 0; i < caixas.size(); i++) {
            if (caixas.get(i).getDono().equals(dono)) {
                return i;
            }
        }
        return -1;
    }

    public void moverCaixa(String dono, String novoCorredor, int novaPosicao) {
        int indice = encontrarCaixa(dono);
        if (indice != -1) {
            Caixa caixa = caixas.get(indice);
            caixa.setCorredor(novoCorredor);
            caixa.setPosicao(novaPosicao);
        }
    }

    
    public int[] caixasMaisPesadasque(double peso) {
        int[] indices = new int[caixas.size()];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = -1;
        }
        int j = 0;
        for (int i = 0; i < caixas.size(); i++) {
            if (caixas.get(i).getPeso() > peso) {
                indices[j] = i;
                j++;
            }
        }
        return indices;
    }
        
}
