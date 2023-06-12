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
import java.util.ArrayList;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class TelaGerarCertificado extends JFrame implements ActionListener {
    ArrayList<Ocorrencia> aLista;
    Ocorrencia event = new Ocorrencia();
    CommandsDB cBD = new CommandsDB();
    private JButton ok;
    private boolean confirm = false;

    private JLabel cpf;

    private JTextField cpfTF;

    // construtor
    public TelaGerarCertificado() {
        super("Tela de Gerar Certificado");
        this.cpf = new JLabel("CPF:");
        this.cpfTF = new JTextField(100);
        this.ok = new JButton("Confirmar");
        Container caixa = getContentPane();

        caixa.setLayout(new BorderLayout());
        JPanel painelSul = new JPanel(new FlowLayout());
        JPanel painelCenter = new JPanel(new GridLayout(5, 2));
        Font fonteINI = new Font("Roboto", Font.BOLD, 16);

        cpf.setFont(fonteINI);
        ok.setFont(fonteINI);

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
        if (e.getSource() == ok) {
            int i = 0 ;
            String cpf = cpfTF.getText();
            event.setCpf(cpf);

            aLista = cBD.buscarTodosEventos(cpf);
            String msg = "";
            for (Ocorrencia ocorrencia : aLista) {
                FileWriter arq;
                msg = ocorrencia.toString() + "\n";
                try {
                    arq = new FileWriter("Certificado_"+i+".txt");
                    PrintWriter gravarArq = new PrintWriter(arq);
                    gravarArq.printf("+----Certificado----+%n");
                    gravarArq.printf(msg);
                    gravarArq.printf("+-------------------+%n");
                    arq.close();
                    i++;
                    JOptionPane.showMessageDialog(null, "Certificado gerado com sucesso!");
                } catch (IOException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao gerar arquivo!");
                }
            }
            confirm = true;
            setVisible(false);
        }
    }

    public boolean getConfirmar() {
        return true;
    }
}
