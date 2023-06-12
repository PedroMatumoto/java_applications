package ex2;

import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.JOptionPane;

public class ContaCorrente {
    private int numeroCC;
    private int digitoCC;
    private Agencia agencia;
    private double saldo;

    public ContaCorrente(int numeroCC, int digitoCC, Agencia agencia,double saldo) {
        this.numeroCC=numeroCC;
        this.digitoCC = digitoCC;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public void depositar(double deposito){
        saldo = saldo+deposito;
    }
    
    public void sacar(double saque) {
        saldo=getSaldo();
        saldo = saldo - saque;
        if (saldo < 0){
            JOptionPane.showMessageDialog(null, "Saldo negativo!");
        }
        saldo =saldo+saque;
        setSaldo(saldo);
    }

    public void imprimirSaldo(){
        String msg = "ContaCorrente [numero=" + numeroCC + ", digito=" + digitoCC + ", Agencia=" + getAgencia()
                + ", saldo=" + saldo + "]";
        JOptionPane.showMessageDialog(null, msg);
    }

    public int getNumeroCC() {
        return numeroCC;
    }

    public int getDigitoCC() {
        return digitoCC;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    // Modificadores

    public void setNumeroCC(int numberCC) {
        numeroCC = numberCC;
    }

    public void setDigitoCC(int digitCC) {
        digitoCC = digitCC;
    }

    public void setAgencia(Agencia agency) {
        agencia = agency;
    }

    public void setSaldo(double debit) {
        saldo = debit;
    }
    

    public String getContaCorrente() {
        return "ContaCorrente [numero=" + numeroCC + ", digito=" + digitoCC + ", Agencia=" + getAgencia() + ", saldo=" +saldo+"]";
    }

}
