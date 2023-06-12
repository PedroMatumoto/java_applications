package VIEW;

import DAO.*;
import DTO.*;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.sql.Connection;
import java.util.ArrayList;

public class TelaExcluir extends JFrame implements ActionListener {
    ArrayList<Ocorrencia> aLista;
    CommandsDB cBD = new CommandsDB();
    private JButton ok;
    private boolean confirm = false;

    private JLabel cpf;
    private JTextField cpfTF;

    // construtor
    public TelaExcluir() {
        super("Tela Excluir");
        this.cpf = new JLabel("CPF:");
        this.cpfTF = new JTextField(100);
        this.ok = new JButton("Confirmar");
        Container caixa = getContentPane();

        caixa.setLayout(new BorderLayout());
        JPanel painelSul = new JPanel(new FlowLayout());
        JPanel painelCenter = new JPanel(new GridLayout(5, 2));
        Font fonteINI = new Font("Roboto", Font.BOLD, 16);


        cpf.setFont(fonteINI);

        cpf.setHorizontalAlignment(SwingConstants.CENTER);

        painelCenter.add(cpf);
        painelCenter.add(cpfTF);
        painelSul.add(ok);
        caixa.add(painelCenter, BorderLayout.CENTER);
        caixa.add(painelSul, BorderLayout.SOUTH);
        ok.addActionListener(this);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Connection conn = null;
        ConnFactory bd = new ConnFactory(); 
        conn = bd.getConn();
        if (e.getSource() == ok) {
            cBD.setCpf(cpfTF.getText());
            cBD.excluirOcorrencia(conn);
            confirm = true;
            setVisible(false);
        }
    }

    public boolean getConfirmar() {
        return true;
    }

}
