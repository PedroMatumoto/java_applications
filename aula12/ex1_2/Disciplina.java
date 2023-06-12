package aula12.ex1_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Disciplina {
    private String nome;
    ArrayList<Professor> professores = new ArrayList<Professor>();
    private String codigo;

    public Disciplina() {
        clearObject();
    }

    public Disciplina(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo.length() > 0) {
            this.codigo = codigo;
        } else {
            this.codigo = "Código inválido";
        }
    }

    public void addProfessor(Professor professor) {
        professores.add(professor);
    }

    public void clearObject() {
        this.nome = "";
        this.codigo = "";
    }

    @Override
    public String toString() {
        String retorno = "Disciplina: " + this.nome + "\n";
        retorno += "Código: " + this.codigo + "\n";
        retorno += "Professores: \n";
        for (Professor professor : professores) {
            retorno += professor.toString() + "\n";
        }
        return retorno;
    }

    public void adicionar(Disciplina dis) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnFactory.getConn();
            stmt = con.prepareStatement("INSERT INTO disciplina (nome, codigo) VALUES (?, ?)");
            stmt.setString(1, dis.getNome());
            stmt.setString(2, dis.getCodigo());
            stmt.executeUpdate();
            stmt.close();
            for (Professor professor : professores) {
                stmt = con.prepareStatement("INSERT INTO disciplina_professor (codigo_disciplina, matricula_professor) VALUES (?, ?)");
                stmt.setString(1, codigo);
                stmt.setInt(2, professor.getMatricula());
                stmt.executeUpdate();
                stmt.close();
            }


        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir uma disciplina: ", ex);
        } finally {
            ConnFactory.closeConn(con, stmt);
        }
    }

    public void excluir(Disciplina dis) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnFactory.getConn();
            stmt = con.prepareStatement("DELETE FROM disciplina WHERE codigo = ?");
            stmt.setString(1, dis.getCodigo());
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao excluir uma disciplina: ", ex);
        } finally {
            ConnFactory.closeConn(con, stmt);
        }
    }

    public void alterar(Disciplina dis) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnFactory.getConn();
            stmt = con.prepareStatement("UPDATE disciplina SET nome = ? WHERE codigo = ?");
            stmt.setString(1, dis.getNome());
            stmt.setString(2, dis.getCodigo());
            stmt.executeUpdate();
            stmt.close();
            stmt = con.prepareStatement("DELETE FROM disciplina_professor WHERE codigo_disciplina = ?");
            stmt.setString(1, codigo);
            stmt.executeUpdate();
            stmt.close();

            // Insere os professores atualizados
            for (Professor professor : professores) {
                stmt = con.prepareStatement("INSERT INTO disciplina_professor (codigo_disciplina, matricula_professor) VALUES (?, ?)");
                stmt.setString(1, codigo);
                stmt.setInt(2, professor.getMatricula());
                stmt.executeUpdate();
                stmt.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao alterar uma disciplina: ", ex);
        } finally {
            ConnFactory.closeConn(con, stmt);
        }
    }

    public void carregar(Disciplina dis) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnFactory.getConn();
            stmt = con.prepareStatement("SELECT * FROM disciplina WHERE codigo = ?");
            stmt.setString(1, dis.getCodigo());
            rs = stmt.executeQuery();
            if (rs.next()) {
                dis.setNome(rs.getString("nome"));
            } else {
                dis.setNome(null);
            }
            rs.close();
            stmt.close();
            stmt = con.prepareStatement("SELECT p.nome, p.idade, p.matricula FROM professores p " +
                    "INNER JOIN disciplina_professor dp ON p.matricula = dp.matricula_professor " +
                    "WHERE dp.codigo_disciplina = ?");
            stmt.setString(1, codigo);
            rs = stmt.executeQuery();
            professores.clear();
            while (rs.next()) {
                String professorNome = rs.getString("nome");
                int professorIdade = rs.getInt("idade");
                int professorMatricula = rs.getInt("matricula");
                Professor professor = new Professor(professorNome, professorIdade, professorMatricula);
                professores.add(professor);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao carregar uma disciplina: ", ex);
        } finally {
            ConnFactory.closeConn(con, stmt, rs);
        }
    }


    
}
