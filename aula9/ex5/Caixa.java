package aula9.ex5;

public class Caixa {
    private String corredor;
    private int posicao;
    private double peso;
    private String dono;

    public Caixa(String corredor, int posicao, double peso, String dono) {
        this.corredor = corredor;
        this.posicao = posicao;
        this.peso = peso;
        this.dono = dono;
    }

    public String getCorredor() {
        return corredor;
    }

    public void setCorredor(String corredor) {
        this.corredor = corredor;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        if (posicao > 0) {
            this.posicao = posicao;
        }
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso > 0) {
            this.peso = peso;
        }
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        if (dono != null) {
            this.dono = dono;
        }
    }
}
