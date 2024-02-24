import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.JOptionPane;

public class ServidorBatepapo {
    public static final String ADDRESS = "127.0.0.1";
    public static final int PORT = 4000;
    private ServerSocket serverSocket;
    private final List<SocketCliente> clientes=new LinkedList<>();

    public void start() throws IOException {
        serverSocket = new ServerSocket(PORT);
        System.out.println("Servidor iniciado na porta: " + PORT);
        clientConnectionLoop();
    }

    private void clientConnectionLoop() throws IOException {
        System.out.println("Aguardando conexões...");
        while (true) {
            SocketCliente clienteSocket = new SocketCliente(serverSocket.accept());
            clientes.add(clienteSocket);
            new Thread(() -> clientMessageLoop(clienteSocket)).start();
            if (clientes.size()>2){
                JOptionPane.showMessageDialog(null, "Quantidade máxima de clientes excedida no servidor"+ADDRESS);
                
            }
        }
    }

    private void clientMessageLoop(SocketCliente clienteSocket) {
        String msg;
        try
        {
            while((msg=clienteSocket.getMessage())!=null)
            {
                if("sair".equalsIgnoreCase(msg)) return;
                System.out.println("Mensagem recebida de "+clienteSocket.getRemoteSocketAddress()+": "+msg);
                sendMsgToAll(clienteSocket, msg);
            }
        }
        finally{
            clienteSocket.close();
        }
    }

    private void sendMsgToAll(SocketCliente sender, String msg) {
        Iterator<SocketCliente> iterator = clientes.iterator();
        while(iterator.hasNext())
        {
            SocketCliente clienteSocket = iterator.next();
            if(!sender.equals(clienteSocket))
            {
                if(!clienteSocket.sendMsg("Cliente "+sender.getRemoteSocketAddress()+":"+msg))
                {
                    iterator.remove();
                    System.out.println("Cliente "+clienteSocket.getRemoteSocketAddress()+" desconectado!");
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("*v*v*v* Servidor de Bate-papo *v*v*v*");
        try {
            ServidorBatepapo server = new ServidorBatepapo();
            server.start();
        } catch (IOException e) {
            System.out.println("Erro ao iniciar o servidor: "+e.getMessage());
        }
        System.out.println("Servidor finalizado!");
        System.out.println("Servidor finalizado!");
    }
    
}
