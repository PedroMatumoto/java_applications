package aula8.ex1;


public class Pagamento {
    private String nomeDoPagador;
    private String cpf;
    private double valorASerPago;

    public Pagamento(String nomeDoPagador,String cpf,double valorASerPago) {
        this.nomeDoPagador = nomeDoPagador;
        this.cpf = cpf;
        this.valorASerPago = valorASerPago;
    }

    // Modificadores

    public void setnomeDoPagador(String nomeDoPagador) {
        this.nomeDoPagador = nomeDoPagador;
    }

    public void setcpf(String cpf) {
        this.cpf = cpf;
    }

    public void setcpf(double valorASerPago) {
        this.valorASerPago = valorASerPago;
    }

    public String getnomeDoPagador(){
        return nomeDoPagador;
    }

    public String getcpf() {
        return cpf;
    }

    public double getvalorASerPago() {
        return valorASerPago;
    }
}
