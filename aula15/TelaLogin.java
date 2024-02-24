


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
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;




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
    private ResourceBundle bn = null;
    

    // construtor
    public TelaLogin() {
        int   op = Integer.parseInt(JOptionPane.showInputDialog(
      "Idioma - Language - Langue\n\n1- Portugues\n2- English\n3- Francaise\n4- Italiano\n\nEscolha:"
                                                             )
                                 );
      // Carga dos arquivos de internacionaliza��o
      switch(op)
      {  case  1: bn = ResourceBundle.getBundle("TelaLogin", new Locale("pt", "BR"));
                  break;
         case  2: bn = ResourceBundle.getBundle("TelaLogin", Locale.US);
                  break;
         case  3: bn = ResourceBundle.getBundle("TelaLogin", Locale.FRANCE);
                  break;
         case 4: bn = ResourceBundle.getBundle("TelaLogin", new Locale("it", "IT"));
                  break;
         default: bn = ResourceBundle.getBundle("TelaLogin");
                  break;
      }

        
        

        this.cadastrar = new JButton(bn.getString("tela1.botao.cadastrar"));
        this.Entrar = new JButton(bn.getString("tela1.botao.entrar"));

        this.titulo = new JLabel(bn.getString("tela1.botao.titulo"));
        this.login = new JLabel(bn.getString("tela1.botao.login"));
        this.senha = new JLabel(bn.getString("tela1.botao.senha"));

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
            JOptionPane.showMessageDialog(null, bn.getString("tela1.botao.cadastrorealizado"));
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
                JOptionPane.showMessageDialog(null, bn.getString("tela1.botao.usuarionaoexiste"));
            }else{
                // se a senha digitada for igual a senha do usuário, o usuário é logado
                if(cBD.getSenha().equals(senha_tf.getText())){
                    JOptionPane.showMessageDialog(null, bn.getString("tela1.botao.logado"));
                    dispose();
                    cBDN.setNome(cBD.getNomeusuario());
                    cBDN.pullNotes(conn);

                }else{
                    JOptionPane.showMessageDialog(null, bn.getString("tela1.botao.senhaincorreta"));
                }
            }
           

        }
    }
      
}
