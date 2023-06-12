package VIEW;

import DAO.*;
import DTO.*;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

public class TelaAlterar extends JFrame implements ActionListener {
    ArrayList<Ocorrencia> aLista;
    Ocorrencia event = new Ocorrencia();
    CommandsDB same;
    CommandsDB cBD = new CommandsDB();
    private JButton ok;
    private boolean confirm = false;

    private JLabel nome;
    private JLabel cpf;
    private JLabel evento;
    private JLabel data;
    private JLabel cargaHoraria;
    private String iptCpf;

    private JTextField nomeTF;
    private JTextField cpfTF;
    private JTextField eventoTF;
    private JTextField dataTF;
    private JTextField cargaHorariaTF;

    // construtor
    public TelaAlterar(){
        super("Tela Alterar");
        iptCpf = JOptionPane.showInputDialog("Digite o CPF do professor que deseja alterar: ");
        this.nome = new JLabel("Nome:");
        this.evento = new JLabel("Evento:");
        this.data = new JLabel("Data:");
        this.cargaHoraria = new JLabel("Carga Horaria:");
        this.nomeTF = new JTextField(100);
        this.eventoTF = new JTextField(100);
        this.dataTF = new JTextField(100);
        this.cargaHorariaTF = new JTextField(100);
        this.ok = new JButton("Confirmar");
        Container caixa = getContentPane();

        caixa.setLayout(new BorderLayout());
        JPanel painelSul = new JPanel(new FlowLayout());
        JPanel painelCenter = new JPanel(new GridLayout(5, 2));
        Font fonteINI = new Font("Roboto", Font.BOLD, 16);

        nome.setFont(fonteINI);
        evento.setFont(fonteINI);
        data.setFont(fonteINI);
        cargaHoraria.setFont(fonteINI);
        ok.setFont(fonteINI);

        nome.setHorizontalAlignment(SwingConstants.CENTER);
        evento.setHorizontalAlignment(SwingConstants.CENTER);
        data.setHorizontalAlignment(SwingConstants.CENTER);
        cargaHoraria.setHorizontalAlignment(SwingConstants.CENTER);

        painelCenter.add(nome);
        painelCenter.add(nomeTF);
        painelCenter.add(evento);
        painelCenter.add(eventoTF);
        painelCenter.add(data);
        painelCenter.add(dataTF);
        painelCenter.add(cargaHoraria);
        painelCenter.add(cargaHorariaTF);
        painelSul.add(ok);
        caixa.add(painelCenter, BorderLayout.CENTER);
        caixa.add(painelSul, BorderLayout.SOUTH);
        ok.addActionListener(this);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        Connection conn = null;
        ConnFactory bd = new ConnFactory(); 
        conn = bd.getConn();
        if (e.getSource() == ok) {    
            String nome = nomeTF.getText();
            String evento = eventoTF.getText();
            String data = dataTF.getText();
            String cargaHoraria = cargaHorariaTF.getText();
            
            cBD.setNome(nome);
            cBD.setEvento(evento);
            cBD.setData(data);
            cBD.setCargaHoraria(cargaHoraria);
            cBD.setCpf(this.iptCpf);
            
            cBD.alterarOcorrencia(conn);
            cBD.consultarOcorrencia(conn);
            confirm = true;
            setVisible(false);
        }
    }

    public boolean getConfirmar() {
        return true;
    }
}
