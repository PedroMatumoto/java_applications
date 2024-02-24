

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.Font;
import java.util.Date;

public class TelaLogin extends JFrame implements ActionListener {
    
    CommandsDB cBD = new CommandsDB();
    Cadastro cadastro = new Cadastro();
    CommandsDBNotes cBDN = new CommandsDBNotes();
    Aluno aluno = new Aluno();
    private JButton cadastrar;
    private JButton Entrar;

    private JLabel titulo;
    private JLabel login;
    private JLabel senha;

    private JTextField login_tf;
    private JPasswordField senha_tf;  
    
    private JLabel lastmod;
    

    // construtor
    public TelaLogin() {
        super("Tela de Login");
        

        this.cadastrar = new JButton("Cadastrar");
        this.Entrar = new JButton("Entrar");

        this.titulo = new JLabel("Bem vindo à consulta de notas!");
        this.login = new JLabel("Login:");
        this.senha = new JLabel("Senha:");

        this.login_tf = new JTextField(20);
        this.senha_tf = new JPasswordField(20);

        Container caixa = getContentPane();

        caixa.setLayout(new BorderLayout());

        JPanel painelcima = new JPanel(new FlowLayout());
        JPanel painelCenter = new JPanel(new GridLayout(2,2));
        JPanel painelbaixo = new JPanel(new GridLayout(1, 2));
        Font fonteINI = new Font("Roboto", Font.BOLD, 16);
        titulo.setFont(fonteINI);
        cadastrar.setFont(fonteINI);
        Entrar.setFont(fonteINI);
        login.setFont(fonteINI);
        senha.setFont(fonteINI);
        painelcima.add(titulo);
        painelbaixo.add(cadastrar);
        painelbaixo.add(Entrar);
        painelCenter.add(login);
        painelCenter.add(login_tf);
        painelCenter.add(senha);
        painelCenter.add(senha_tf);
        
        caixa.add(painelcima, BorderLayout.NORTH);
        caixa.add(painelCenter, BorderLayout.CENTER);
        caixa.add(painelbaixo, BorderLayout.SOUTH);

        cadastrar.addActionListener(this);
        Entrar.addActionListener(this);

        setSize(325, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Connection conn = null;
        ConnFactory bd = new ConnFactory();
        conn = bd.getConn();
        if (e.getSource() == cadastrar) {
            cBD.setNomeusuario(login_tf.getText());
            cBD.setSenha(senha_tf.getText());
            cBD.CriarCadastro(conn);
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
            cBDN.setNome(cBD.getNomeusuario());
            //cria um linha em notas para o usuário
            cBDN.createNotes(conn);
            cBDN.pullNotes(conn);
            dispose();
        }

        if(e.getSource() == Entrar){
            cBD.setNomeusuario(login_tf.getText());
            cBD.setSenha(senha_tf.getText());
            cBD.consultarCadastro(conn);
            // se nenhuma linha for retornada, significa que o usuário não existe
            if(cBD.getNomeusuario() == null){
                JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
            }else{
                // se a senha digitada for igual a senha do usuário, o usuário é logado
                if(cBD.getSenha().equals(senha_tf.getText())){
                    JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
                    dispose();
                    cBDN.setNome(cBD.getNomeusuario());
                    cBDN.pullNotes(conn);

                }else{
                    JOptionPane.showMessageDialog(null, "Senha incorreta!");
                }
            }
           

        }
    }
      
}
