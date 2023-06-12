/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.ConnFactory;
import DTO.Ocorrencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CommandsDB extends Ocorrencia {
    
    /// inserir
    public void inserirOcorrencia(Connection conn){
        String sqlInsert = "INSERT INTO EVENTS_DB(nome, cpf, evento, data, carga_horaria) VALUES(?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = ConnFactory.getConn().prepareStatement(sqlInsert);
            stmt.setString(1, getNome());
            stmt.setString(2, getCpf());
            stmt.setString(3, getEvento());
            stmt.setString(4, getData());
            stmt.setString(5, getCargaHoraria());
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
    
    /// carregar
    public void consultarOcorrencia(Connection conn){
        String sqlSelect = "SELECT * FROM EVENTS_DB WHERE cpf = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = ConnFactory.getConn().prepareStatement(sqlSelect);
            stmt = conn.prepareStatement(sqlSelect);
            stmt.setString(1, getCpf());
            rs = stmt.executeQuery();
            if(rs.next()){
                setNome(rs.getString(1));
                setCpf(rs.getString(2));
                setEvento(rs.getString(3));
                setData(rs.getString(4));
                setCargaHoraria(rs.getString(5));
            }
            System.out.println(toString());
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
    
    /// alterar
    public void alterarOcorrencia(Connection conn){
        String sqlUpdate = "UPDATE EVENTS_DB SET nome = ?, evento = ?, data = ?, carga_horaria = ? WHERE cpf = ? ";
        PreparedStatement stmt = null;
        try {
            stmt = ConnFactory.getConn().prepareStatement(sqlUpdate);
            stmt.setString(1, getNome());
            stmt.setString(2, getEvento());
            stmt.setString(3, getData());
            stmt.setString(4, getCargaHoraria());
            stmt.setString(5, getCpf());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.setAutoCommit(false);
                conn.rollback();
            } catch (SQLException e1) {
                System.out.println("Erro ao alterar os dados " + e1.toString());
                throw new RuntimeException(e1);
            }
        }
    }
    
    /// excluir
    public void excluirOcorrencia(Connection conn){
        String sqlDelete = "DELETE FROM EVENTS_DB WHERE cpf = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sqlDelete);
            stmt.setString(1, getCpf());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.setAutoCommit(false);
                conn.rollback();
            } catch (SQLException e1) {
                System.out.println("Erro ao excluir os dados " + e1.toString());
                throw new RuntimeException(e1);
            }
        }
    }
    
    /// carregar lista
    public ArrayList<Ocorrencia> buscarTodosEventos(String cpf) {
        String sqlSelect = "SELECT * FROM EVENTS_DB WHERE cpf = ?";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;
        ResultSet rs;
        ArrayList<Ocorrencia> lista = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sqlSelect);
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Ocorrencia oc = new Ocorrencia();
                oc.setNome(rs.getString("nome"));
                oc.setCpf(rs.getString("cpf"));
                oc.setEvento(rs.getString("evento"));
                oc.setData(rs.getString("data"));
                oc.setCargaHoraria(rs.getString("carga_horaria"));
                lista.add(oc);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar os dados (array) " + ex.toString());
        } finally {
            //ConnFactory.closeConn(conn, stmt);
        }
        return lista;
    }
}
