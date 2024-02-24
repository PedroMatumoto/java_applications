import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JTable;

import javax.swing.JOptionPane;



import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.table.DefaultTableModel;

public class CommandsDBNotes extends Aluno implements ActionListener{
    private JButton inserir;
    private JButton ler;
    JFrame frame;
    JTable jTable;
    DefaultTableModel tableModel;

    

    public void createNotes(Connection conn){
        String sqlInsert = "INSERT INTO notas VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = ConnFactory.getConn().prepareStatement(sqlInsert);
            stmt.setDouble(2, 0);
            stmt.setDouble(3, 0);
            stmt.setDouble(4, 0);
            stmt.setDouble(5, 0);
            stmt.setDouble(6, 0);
            stmt.setDouble(7, 0);
            stmt.setInt(8, 0);
            stmt.setString(1, getNome());
            stmt.setString(9, new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
            stmt.executeUpdate();
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
    public void pushNotes(Connection conn){
        String sqlInsert = "UPDATE notas SET T1 = ?, T2 = ?, T3 = ?,T4 = ?, P1 = ?, P2 = ?, FALTAS = ?, lastmod = ? WHERE nome = ? ";
        PreparedStatement stmt = null;
        try {
            Object nome = jTable.getValueAt(1, 0);
            String nomeAluno = nome.toString();

            Object T1 = jTable.getValueAt(1, 1);
            String t1String = T1.toString();
            float t1= Float.parseFloat(t1String);

            Object T2 = jTable.getValueAt(1, 2);
            String t2String = T2.toString();
            float t2= Float.parseFloat(t2String);

            Object T3 = jTable.getValueAt(1, 3);
            String t3String = T3.toString();
            float t3= Float.parseFloat(t3String);

            Object T4 = jTable.getValueAt(1, 4);
            String t4String = T4.toString();
            float t4= Float.parseFloat(t4String);

            Object P1 = jTable.getValueAt(1, 5);
            String p1String = P1.toString();
            float p1= Float.parseFloat(p1String);

            Object P2 = jTable.getValueAt(1, 6);
            String p2String = P2.toString();
            float p2= Float.parseFloat(p2String);
            
            Object FALTAS = jTable.getValueAt(1, 7);
            String faltasString = FALTAS.toString();
            int faltas = Integer.parseInt(faltasString);



            stmt = ConnFactory.getConn().prepareStatement(sqlInsert);
            stmt.setDouble(1, t1);
            stmt.setDouble(2, t2);
            stmt.setDouble(3, t3);
            stmt.setDouble(4, t4);
            stmt.setDouble(5, p1);
            stmt.setDouble(6, p2);
            stmt.setInt(7, faltas);
            stmt.setString(8, new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
            stmt.setString(9, nomeAluno);
            stmt.executeUpdate();
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

    public void pullNotes(Connection Conn){
        
        String sql = "SELECT nome, T1, T2, T3, T4, P1, P2, FALTAS, lastmod FROM notas where nome = '"+getNome()+"'";
        try{
            Statement stmt = Conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Criar o modelo da tabela
            
            tableModel = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return row != 0 && column != 8;
                    
                }
            };
            tableModel.addColumn("Nome");
            tableModel.addColumn("Nota T1");
            tableModel.addColumn("Nota T2");
            tableModel.addColumn("Nota T3");
            tableModel.addColumn("Nota T4");
            tableModel.addColumn("P1");
            tableModel.addColumn("P2");
            tableModel.addColumn("Faltas");
            tableModel.addColumn("LastMod");

            // Preencher o modelo com os dados do banco de dados
            while (rs.next()) {
                String nome = rs.getString("nome");
                double notaT1 = rs.getDouble("T1");
                double notaT2 = rs.getDouble("T2");
                double notaT3 = rs.getDouble("T3");
                double notaT4 = rs.getDouble("T4");
                double p1 = rs.getDouble("P1");
                double p2 = rs.getDouble("P2");
                int faltas = rs.getInt("FALTAS");
                String lastMod = rs.getString("lastmod");
                

                // cabeçalho da tabela não editável
                tableModel.addRow(new Object[]{"Nome", "Nota T1", "Nota T2", "Nota T3", "Nota T4", "P1", "P2", "Faltas", "lastmod"});
                // dados da tabela editáveis
                tableModel.addRow(new Object[]{nome, notaT1, notaT2, notaT3, notaT4, p1, p2, faltas,lastMod});
            }

            // Criar o JTable com o modelo de tabela
            jTable = new JTable(tableModel);

            this.inserir = new JButton("Inserir novas notas no DB");
            this.ler = new JButton("Ler notas do DB");
            inserir.addActionListener(this);
            ler.addActionListener(this);

            // Criar um JScrollPane para exibir o JTable em caso de muitos dados

            // Criar o JFrame e adicionar o JScrollPane
            frame = new JFrame("Notas de "+ getNome()); 
            frame.setSize(700, 120);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new FlowLayout());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(jTable);
            frame.add(inserir);
            frame.add(ler);
            frame.setVisible(true);
            // se a tabela estiver vazia, falar que não há dados
            if (tableModel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Não há dados para este cadastro");
                frame.dispose();
                TelaLogin tela = new TelaLogin();
                tela.setVisible(true);
            }
            // Executar a consulta SQL
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void actionPerformed(ActionEvent e){
         if (e.getSource() == inserir){
            pushNotes(ConnFactory.getConn());
            frame.dispose();
            pullNotes(ConnFactory.getConn());
         }
         if(e.getSource()==ler){
            //fecha a janela anterior
            frame.dispose();
            pullNotes(ConnFactory.getConn());
         }
        

    }
    
}
