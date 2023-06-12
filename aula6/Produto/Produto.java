package aula6.Produto;

import javax.swing.JOptionPane;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;
        
    public Produto(String name, double price, int quantity) {
        this.nome = name;
        this.preco = price;
        this.quantidade=quantity;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }


    // Modificadores

    public void setNome(String name) {
        nome = name;
    }

    public void setPreco(double price) {
        preco = price;
    }

    public void setQuantidade(int quantity) {
        quantidade = quantity;
    }


}
