package aula8.ex1;

public class Boleto extends Pagamento {
    private String numeroDoBoleto;
    private int dia;
    private int mes;
    private int ano;
    
    public Boleto(String nomeDoPagador,String cpf,double valorASerPago, String numeroDoBoleto, int dia, int mes, int ano){
        super(nomeDoPagador,cpf,valorASerPago);
        this.numeroDoBoleto=numeroDoBoleto;
        this.dia=dia;
        this.mes=mes;
        this.ano=ano;
    }

    public void setnumeroDoBoleto(String numeroDoBoleto){
        this.numeroDoBoleto=numeroDoBoleto;
    }

    public void setdia(int dia) {
        this.dia = dia;
    }

    public void setmes(int mes) {
        this.mes = mes;
    }

    public void setano(int ano) {
        this.ano = ano;
    }

    public String getnumeroDoBoleto(){
        return numeroDoBoleto;
    }

    public int getdia(){
        return dia;
    }

    public int getmes() {
        return mes;
    }

    public int getano() {
        return ano;
    }
}
