package aula8.ex1;

public class CartaoDeCredito extends Pagamento {
    private String numeroDoCartao;
    public CartaoDeCredito(String nomeDoPagador, String cpf, double valorASerPago,String numeroDoCartao){
        super(nomeDoPagador, cpf, valorASerPago);
        this.numeroDoCartao=numeroDoCartao;
    }
    public void setnumeroDoCartao(String numeroDoCartao){
        this.numeroDoCartao=numeroDoCartao;
    }
    public String getnumeroDoCartao(){
        return numeroDoCartao;
    }
}
    

