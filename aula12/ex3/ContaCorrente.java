package aula12.ex3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContaCorrente {
    private int numero;
    private int digito;
    private Agencia agencia;
    private double saldo;

    public ContaCorrente(int numero, int digito, Agencia agencia) {
        if (numero > 0 && numero <= 9999) {
            this.numero = numero;
        } else {
            System.out.println("Número da conta inválido.");
        }

        int calculatedDigit = calculateDigit(numero);
        if (calculatedDigit == digito) {
            this.digito = digito;
        } else {
            System.out.println("Dígito da conta inválido.");
        }

        this.agencia = agencia;
        this.saldo = 0.0;
    }

    private int calculateDigit(int number) {
        int sum = 0;
        int multiplier = 4;

        for (int i = 0; i < 4; i++) {
            int digit = number % 10;
            sum += digit * multiplier;
            multiplier += 2;
            number /= 10;
        }

        int remainder = sum % 11;
        return (remainder == 10) ? 0 : remainder;
    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getDigito() {
        return digito;
    }

    public void setDigito(int digito) {
        this.digito = digito;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public double sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            return valor;
        } else {
            System.out.println("Saque não realizado. Saldo insuficiente.");
            return 0.0;
        }
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void imprimirSaldo() {
        System.out.println("Conta: " + numero + "-" + digito);
        System.out.println("Agência: " + agencia.getNumero() + "-" + agencia.getDigito());
        System.out.println("Saldo: R$" + saldo);
    }

    public void inserir(ContaCorrente conta){
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnFactory.getConn();
            stmt = conn.prepareStatement("INSERT INTO contas (numero, digito, saldo, agencia_numero, agencia_digito) VALUES (?, ?, ?, ?, ?)");
            stmt.setInt(1, conta.getNumero());
            stmt.setInt(2, conta.getDigito());
            stmt.setDouble(3, conta.getSaldo());
            stmt.setInt(4, conta.getAgencia().getNumero());
            stmt.setInt(5, conta.getAgencia().getDigito());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
    }

    public void atualizar(ContaCorrente conta){
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnFactory.getConn();
            stmt = conn.prepareStatement("UPDATE contas SET saldo = ? WHERE numero = ? AND digito = ?");
            stmt.setDouble(1, conta.getSaldo());
            stmt.setInt(2, conta.getNumero());
            stmt.setInt(3, conta.getDigito());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
    }

    public void excluir(ContaCorrente conta){
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnFactory.getConn();
            stmt = conn.prepareStatement("DELETE FROM contas WHERE numero = ? AND digito = ?");
            stmt.setInt(1, conta.getNumero());
            stmt.setInt(2, conta.getDigito());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
    }

    public void consultar(ContaCorrente conta){
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnFactory.getConn();
            stmt = conn.prepareStatement("SELECT * FROM contas WHERE numero = ? AND digito = ?");
            stmt.setInt(1, conta.getNumero());
            stmt.setInt(2, conta.getDigito());
            stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
    }
}