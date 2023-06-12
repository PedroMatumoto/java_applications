package aula10.TickTack;

public class Mostrador {
    private int valor;
    private int limite;
    public Mostrador(int limite){
        this.limite=limite;
        valor=0;
    }
    public int getValor(){
        return valor;
    }
    public void setValor(int valor){
        this.valor=valor;
    }
    public void incrementa(){
        valor=(valor+1)%limite;
    }
    public String mostra(){
        if (valor<10) return "0"+valor;
        else return ""+valor;
    }
}
