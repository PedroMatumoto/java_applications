import java.io.*;
import java.net.*;
import java.util.*;

public class ClienteBatepapo implements Runnable{
   private SocketCliente clienteSocket;
   private Scanner scanner;

   public ClienteBatepapo() {
      scanner = new Scanner(System.in);
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
            System.out.println(msg);
            System.out.println("Digite uma mensagem: ");
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
            ClienteBatepapo client = new ClienteBatepapo();
            client.start();
        } catch (IOException e) {
            System.out.println("Erro ao iniciar o cliente: "+e.getMessage());
        }
        System.out.println("Cliente finalizado!");
    }
    
}
