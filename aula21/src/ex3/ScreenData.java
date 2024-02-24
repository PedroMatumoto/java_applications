package ex3;
import javax.swing.JFrame;
import javax.sound.sampled.SourceDataLine;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.awt.Font;

public class ScreenData extends JFrame implements ActionListener{

    private static Socket client;
    private JButton limpar;
    private JButton sair;
    private JButton enviar;
 
    private JLabel mensagem;

    private JTextField texto;

    public boolean leave = false;

    public String text;

    public JLabel estadoConexao;

    public JLabel receiveMessage;

    public ScreenData(){

        super("Tela de dados");
        this.limpar = new JButton("Limpar");
        this.sair = new JButton("Sair");
        this.enviar = new JButton("Enviar");
        this.mensagem = new JLabel("Mensagem");
        this.texto = new JTextField(20);
        this.estadoConexao = new JLabel("");
        this.receiveMessage = new JLabel("");

        Container caixa = getContentPane();
        caixa.setLayout(new BorderLayout());
        JPanel painelcima = new JPanel(new FlowLayout());
        JPanel painelCenter = new JPanel(new FlowLayout());
        JPanel painelbaixo = new JPanel(new GridLayout(1, 3));
        Font fonteINI = new Font("Roboto", Font.BOLD, 16);
        mensagem.setFont(fonteINI);
        texto.setFont(fonteINI);
        limpar.setFont(fonteINI);
        sair.setFont(fonteINI);
        enviar.setFont(fonteINI);
        painelcima.add(mensagem);
        painelcima.add(texto);
        painelbaixo.add(limpar);
        painelbaixo.add(sair);
        painelbaixo.add(enviar);
        painelCenter.add(estadoConexao);
        painelCenter.add(receiveMessage);
        caixa.add(painelcima, BorderLayout.NORTH);
        caixa.add(painelbaixo, BorderLayout.SOUTH);
        caixa.add(painelCenter, BorderLayout.CENTER);
        limpar.addActionListener(this);
        sair.addActionListener(this);
        enviar.addActionListener(this);

        setSize(600, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            iniciaCliente();
        } catch (IOException ex) {
            estadoConexao.setText("Falha na comunicação: " + ex.getMessage());
        }
    }
    public void actionPerformed(ActionEvent e) {
            if (e.getSource() == limpar) {
                texto.setText("");
            }
            if (e.getSource() == sair) {
                System.exit(0);
            }
            if (e.getSource() == enviar) {
                try{
                    enviarMensagem(texto.getText());
                    Scanner s = new Scanner(client.getInputStream());
                    String servidor = s.nextLine();
                    receiveMessage.setText("Retorno Servidor: "+servidor);
                }
                catch(IOException ex){
                    estadoConexao.setText("Falha na comunicação: " + ex.getMessage());
                }
            }
    }
    private static void iniciaCliente() throws IOException{
        client = new Socket(SimpleServer2Test.HOST, SimpleServer2Test.PORT);
        System.out.println("Cliente conectado ao servidor "+SimpleServer2Test.HOST+":"+SimpleServer2Test.PORT);
    }

    private static void enviarMensagem(String msg) throws IOException{
        PrintStream ps = new PrintStream(client.getOutputStream());
        ps.println(msg);
    }
    
}
