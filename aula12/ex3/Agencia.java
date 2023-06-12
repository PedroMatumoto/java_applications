package aula12.ex3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Agencia {
    private String nome;
    private int numero;
    private int digito;

    public Agencia(String nome, int numero, int digito) {
        this.nome = nome;

        if (numero > 0 && numero <= 9999) {
            this.numero = numero;
        } else {
            System.out.println("Número da agência inválido.");
        }

        int calculatedDigit = calculateDigit(numero);
        if (calculatedDigit == digito) {
            this.digito = digito;
        } else {
            System.out.println("Dígito da agência inválido.");
        }
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if (numero > 0 && numero <= 9999) {
            this.numero = numero;
        } else {
            System.out.println("Número da agência inválido.");
        }
    }

    public int getDigito() {
        return digito;
    }

    public void setDigito(int digito) {
        int calculatedDigit = calculateDigit(numero);
        if (calculatedDigit == digito) {
            this.digito = digito;
        } else {
            System.out.println("Dígito da agência inválido.");
        }
    }

    public void adicionar(Agencia agencia) {
       Connection connection = null;
         try {
              connection = ConnFactory.getConn();
              String sql = "INSERT INTO agencia (nome, numero, digito) VALUES (?, ?, ?)";
              PreparedStatement statement = connection.prepareStatement(sql);
              statement.setString(1, agencia.getNome());
              statement.setInt(2, agencia.getNumero());
              statement.setInt(3, agencia.getDigito());
              statement.executeUpdate();
         } catch (SQLException e) {
              e.printStackTrace();
         } finally {
              ConnFactory.closeConn(connection);
         }
    }

    public void remover(Agencia agencia) {
       Connection connection = null;
         try {
              connection = ConnFactory.getConn();
              String sql = "DELETE FROM agencia WHERE numero = ?";
              PreparedStatement statement = connection.prepareStatement(sql);
              statement.setInt(1, agencia.getNumero());
              statement.executeUpdate();
         } catch (SQLException e) {
              e.printStackTrace();
         } finally {
              ConnFactory.closeConn(connection);
         }
    }

    public void atualizar(Agencia agencia) {
       Connection connection = null;
         try {
              connection = ConnFactory.getConn();
              String sql = "UPDATE agencia SET nome = ?, digito = ? WHERE numero = ?";
              PreparedStatement statement = connection.prepareStatement(sql);
              statement.setString(1, agencia.getNome());
              statement.setInt(2, agencia.getDigito());
              statement.setInt(3, agencia.getNumero());
              statement.executeUpdate();
         } catch (SQLException e) {
              e.printStackTrace();
         } finally {
              ConnFactory.closeConn(connection);
         }
    }

    public void listar() {
       Connection connection = null;
         try {
              connection = ConnFactory.getConn();
              String sql = "SELECT * FROM agencia";
              PreparedStatement statement = connection.prepareStatement(sql);
              statement.executeQuery();
         } catch (SQLException e) {
              e.printStackTrace();
         } finally {
              ConnFactory.closeConn(connection);
         }
    }
    
}
