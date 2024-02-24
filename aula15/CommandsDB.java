

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class CommandsDB extends Cadastro{
    public void consultarCadastro(Connection conn){
        String sqlSelect = "SELECT * FROM cadastros WHERE nome = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = ConnFactory.getConn().prepareStatement(sqlSelect);
            stmt = conn.prepareStatement(sqlSelect);
            stmt.setString(1, getNomeusuario());
            rs = stmt.executeQuery();
            if(rs.next()){
                setNomeusuario(rs.getString(1));
                setSenha(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.setAutoCommit(false);
                conn.rollback();
            } catch (SQLException e1) {
                System.out.println("Erro ao consultar os dados " + e1.toString());
                throw new RuntimeException(e1);
            }
        }        
    }

    public void CriarCadastro(Connection conn){
        String sqlInsert = "INSERT INTO cadastros(nome, senha) VALUES(?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = ConnFactory.getConn().prepareStatement(sqlInsert);
            stmt.setString(1, getNomeusuario());
            stmt.setString(2, getSenha());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.setAutoCommit(false);
                conn.rollback();
            } catch (SQLException e1) {
                System.out.println("Erro ao incluir os dados " + e1.toString());
                throw new RuntimeException(e1);
            }
        }
    }
    
}
