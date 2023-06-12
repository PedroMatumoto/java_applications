package aula6.Produto;

import javax.swing.JOptionPane;

public class testeproduto {

    public static void main(String[] args) {
        String nome = JOptionPane.showInputDialog("Nome:");
        double preco= Double.parseDouble(JOptionPane.showInputDialog("Preco"));
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade:"));

        Produto produto = new Produto(nome, preco, quantidade);

        String msg = "Nome: " + produto.getNome() + "\nPreco: " + produto.getPreco() + " reais" + "\nQuantidade: "+produto.getQuantidade();

        JOptionPane.showMessageDialog(null, msg);

    }

}
