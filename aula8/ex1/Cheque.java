package aula8.ex1;

public class Cheque extends Pagamento{

    private String numeroDoCheque;


    public Cheque(String numeroDoCheque, String nomeDoPagador, String cpf, double valorASerPago) {
        super(numeroDoCheque, numeroDoCheque, valorASerPago);
        this.numeroDoCheque = numeroDoCheque;
    }

    public void setnumeroDoCheque(String numeroDoCheque) {
        this.numeroDoCheque = numeroDoCheque;
    }

    public String getnumeroDoCheque() {
        return numeroDoCheque;
    }
}
