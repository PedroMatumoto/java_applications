package aula12.ex1_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Professor {

    private String nome;
    private int idade;
    private int matricula;

    public Professor() {
        clearObject();
    }

    public Professor(int matricula) {
        this.matricula = matricula;
    }
    
    public Professor(String nome, int idade, int matricula) {
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() > 0) {
            this.nome = nome;
        } else {
            this.nome = "Nome inválido";
        }
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade > 0) {
            this.idade = idade;
        } else {
            this.idade = 0;
        }
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        if (matricula > 0) {
            this.matricula = matricula;
        } else {
            this.matricula = 0;
        }
    }

    public void clearObject() {
        this.nome = "";
        this.idade = 0;
        this.matricula = 0;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", matricula=" + matricula +
                '}';
    }

    public void adicionar(Professor pro) {
        String sqlInsert = "INSERT INTO professores(nome, idade, matricula) VALUES(?,?,?)";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sqlInsert);
            stmt.setString(1, pro.getNome());
            stmt.setInt(2, pro.getIdade());
            stmt.setInt(3, pro.getMatricula());
            stmt.executeUpdate();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                System.out.println("Erro ao incluir os dados" + ex.toString());
            }
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
    }

    public void excluir(Professor pro) {
        String sqlDelete = "DELETE FROM professores WHERE matricula = ?";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sqlDelete);
            stmt.setInt(1, pro.getMatricula());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir os dados" + ex.toString());
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
    }

    public void alterar(Professor pro) {
        String sqlUpdate = "UPDATE professores SET nome = ?, idade = ? WHERE matricula = ?";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sqlUpdate);
            stmt.setString(1, pro.getNome());
            stmt.setInt(2, pro.getIdade());
            stmt.setInt(3, pro.getMatricula());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao alterar os dados" + ex.toString());
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
    }

    public void carregar(Professor pro) {
        String sqlSelect = "SELECT * FROM professores WHERE matricula = ?";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;
        ResultSet rs;
        try {
            stmt = conn.prepareStatement(sqlSelect);
            stmt.setInt(1, pro.getMatricula());
            rs = stmt.executeQuery();
            if (rs.next()) {
                pro.setNome(rs.getString("nome"));
                pro.setIdade(rs.getInt("idade"));
                pro.setMatricula(rs.getInt("matricula"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao carregar os dados" + ex.toString());
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
    }

}
