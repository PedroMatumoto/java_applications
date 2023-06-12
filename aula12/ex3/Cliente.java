package aula12.ex3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cliente {
    private String nome;
    private String cpf;
    private ContaCorrente conta;

    public Cliente(String nome, String cpf, ContaCorrente conta) {
        this.nome = nome;
        this.cpf = cpf;
        this.conta = conta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ContaCorrente getConta() {
        return conta;
    }

    public void setConta(ContaCorrente conta) {
        this.conta = conta;
    }

    public void inserir(Cliente cliente){
        Connection conn = null;
        try {
            conn = ConnFactory.getConn();
            String sql = "INSERT INTO cliente (nome, cpf, conta) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setInt(3, cliente.getConta().getNumero());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnFactory.closeConn(conn);
        }
    }

    public void excluir(Cliente cliente){
        Connection conn = null;
        try {
            conn = ConnFactory.getConn();
            String sql = "DELETE FROM cliente WHERE cpf = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getCpf());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnFactory.closeConn(conn);
        }
    }

    public void alterar(Cliente cliente){
        Connection conn = null;
        try {
            conn = ConnFactory.getConn();
            String sql = "UPDATE cliente SET nome = ? WHERE cpf = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnFactory.closeConn(conn);
        }
    }

    public void carregar(Cliente cliente){
        Connection conn = null;
        try {
            conn = ConnFactory.getConn();
            String sql = "SELECT * FROM cliente WHERE cpf = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getCpf());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnFactory.closeConn(conn);
        }
    }
}