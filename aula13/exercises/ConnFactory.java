package aula13.exercises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnFactory {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/AplicativoLogin";
    private static final String USER = "root";
    private static final String PASS = "mysql";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String ERROBD = "Erro na conexão com o Banco de Dados: ";
    
    private static Connection conn = null;
    
    public static Connection getConn(){
        
        //// Driver
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            throw new RuntimeException(ERROBD + e);
        }
        
        //// SQL
        try {
            if(conn == null){
                conn = DriverManager.getConnection(URL,USER,PASS);
                return conn;
            }else{
                return conn;
            }
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(ERROBD + e);
        }
    }
    
    /// close
    public static void closeConn(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(ERROBD + e);
        }
    }

    public static void closeConn(Connection conn, PreparedStatement stmt) {
        closeConn(conn);
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(ERROBD + e);
        }
    }

    public static void closeConn(Connection conn, PreparedStatement stmt, ResultSet rs) {
        closeConn(conn, stmt);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(ERROBD + e);
        }
    }
    
}
