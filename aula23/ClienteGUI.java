import java.io.*;
import java.net.*;
import java.util.*;
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

public class ClienteGUI extends JFrame implements Runnable, ActionListener {
   private SocketCliente clienteSocket;
   private Scanner scanner;

   private static Socket client;
   private JButton limpar;
   private JButton sair;
   private JButton enviar;

   private JLabel mensagem;

   private JTextField texto;

   private JLabel msgExt;




   public ClienteGUI() {
       super("Tela de dados");
       this.limpar = new JButton("Limpar");
       this.sair = new JButton("Sair");
       this.enviar = new JButton("Enviar");
       this.mensagem = new JLabel("Mensagem");
       this.msgExt = new JLabel("Mensagem Externa:");
       this.texto = new JTextField(20);

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
        painelCenter.add(msgExt);
       caixa.add(painelcima, BorderLayout.NORTH);
       caixa.add(painelbaixo, BorderLayout.SOUTH);
       caixa.add(painelCenter, BorderLayout.CENTER);
       limpar.addActionListener(this);
        sair.addActionListener(this);
        enviar.addActionListener(this);


       setSize(600, 200);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      scanner = new Scanner(System.in);
   }

   public void actionPerformed(ActionEvent e){
       if (e.getSource() == limpar) {
           texto.setText("");
       }
       if (e.getSource() == sair) {
           System.exit(0);
       }
       if (e.getSource() == enviar) {
           clienteSocket.sendMsg(texto.getText());
            texto.setText("");
           
       }
   }

   

   public void start() throws IOException {
      try{
        clienteSocket=new SocketCliente(new Socket(ServidorBatepapo.ADDRESS, ServidorBatepapo.PORT));
        new Thread(this).start();
        messageLoop();
      }
      finally{
        clienteSocket.close();
      }
   }

   @Override

    public void run() {
        String msg;
        while((msg=clienteSocket.getMessage())!=null)
        {
            msgExt.setText("Mensagem Externa> "+msg);
        }
    }

    private void messageLoop() throws IOException{
        String msg;
        System.out.println("Digite uma mensagem: ");
        do{
            msg=scanner.nextLine();
            clienteSocket.sendMsg(msg);
        }
        while(!"sair".equalsIgnoreCase(msg));
    }

    public static void main(String[] args) {
        System.out.println("*v*v*v* Cliente de Bate-papo *v*v*v*");
        try {
            ClienteGUI client = new ClienteGUI();
            client.start();
        } catch (IOException e) {
            System.out.println("Erro ao iniciar o cliente: "+e.getMessage());
        }
        System.out.println("Cliente finalizado!");
    }
    
}
