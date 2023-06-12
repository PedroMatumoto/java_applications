package VIEW;

import DAO.*;
import DTO.*;

import java.sql.Connection;

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
import java.util.ArrayList;

public class TelaCadastro extends JFrame implements ActionListener {
    ArrayList<Ocorrencia> aLista;
    Ocorrencia event = new Ocorrencia();
    CommandsDB cBD = new CommandsDB();
    private JButton ok;
    private boolean confirm = false;

    private JLabel nome;
    private JLabel cpf;
    private JLabel evento;
    private JLabel data;
    private JLabel cargaHoraria;

    private JTextField nomeTF;
    private JTextField cpfTF;
    private JTextField eventoTF;
    private JTextField dataTF;
    private JTextField cargaHorariaTF;

    // construtor
    public TelaCadastro() {
        super("Tela Cadastro");
        this.nome = new JLabel("Nome:");
        this.cpf = new JLabel("CPF:");
        this.evento = new JLabel("Evento:");
        this.data = new JLabel("Data:");
        this.cargaHoraria = new JLabel("Carga Horaria:");
        this.nomeTF = new JTextField(100);
        this.cpfTF = new JTextField(100);
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
        cpf.setFont(fonteINI);
        evento.setFont(fonteINI);
        data.setFont(fonteINI);
        cargaHoraria.setFont(fonteINI);
        ok.setFont(fonteINI);

        nome.setHorizontalAlignment(SwingConstants.CENTER);
        cpf.setHorizontalAlignment(SwingConstants.CENTER);
        evento.setHorizontalAlignment(SwingConstants.CENTER);
        data.setHorizontalAlignment(SwingConstants.CENTER);
        cargaHoraria.setHorizontalAlignment(SwingConstants.CENTER);

        painelCenter.add(nome);
        painelCenter.add(nomeTF);
        painelCenter.add(cpf);
        painelCenter.add(cpfTF);
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

    public void actionPerformed(ActionEvent e) {
        Connection conn = null;
        ConnFactory bd = new ConnFactory(); 
        conn = bd.getConn();
        if (e.getSource() == ok) {
            String nome = nomeTF.getText();
            String cpf = cpfTF.getText();
            String evento = eventoTF.getText();
            String data = dataTF.getText();
            String cargaHoraria = cargaHorariaTF.getText();
            cBD.setNome(nome);
            cBD.setCpf(cpf);
            cBD.setEvento(evento);
            cBD.setData(data);
            cBD.setCargaHoraria(cargaHoraria);
            cBD.inserirOcorrencia(conn);
            cBD.consultarOcorrencia(conn);
            confirm=true;
            setVisible(false);
        }
    }

    public boolean getConfirmar(){
        return true;
    }
   
}
