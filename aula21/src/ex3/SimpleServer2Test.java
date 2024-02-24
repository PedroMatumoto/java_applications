package ex3;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;

import javax.swing.JOptionPane;
public class SimpleServer2Test {
    public static final String HOST = "127.0.0.1";
    public static final int PORT = 3334;
    public static Socket client;

    public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Servidor iniciado na porta " + PORT);
            Socket client = server.accept();
            System.out.println("Cliente conectado do IP " + client.getInetAddress().getHostAddress()+ "Conectado");
            Scanner s = new Scanner(client.getInputStream());
            PrintStream saida = new PrintStream(client.getOutputStream());
            System.out.println("Mensagem do cliente: ");
            while(s.hasNextLine()){
                String message = s.nextLine();
                System.out.println(message);
                String opcao = JOptionPane.showInputDialog("Digite sim para editar ou não para enviar");
                if(opcao.equals("sim")){
                    message = JOptionPane.showInputDialog("Mensagem atual: "+message);
                    saida .println(message);
                }
                else
                    saida.println(message);
                System.out.println("Mensagem enviada ao cliente");
                
            }
            System.out.println("Cliente desconectado");
            s.close();
            server.close();
        } catch (IOException e){
            System.out.println("Erro ao criar o servidor");
        }
    } 
}