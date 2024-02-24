import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;
import java.io.PrintStream;

public class SimpleClientTest {
    private static Socket client;
    public static void main(String[] args) {
        try{
            String msg;
            iniciaCliente();
            System.out.println("Mensagens para o servidor");
            do{
                msg = JOptionPane.showInputDialog("Digite uma mensagem para o servidor ou <sair>");
                if(!msg.equalsIgnoreCase("sair")){
                    System.out.println(msg);
                    enviarMensagem(msg);
                }
            }
            while(!msg.equalsIgnoreCase("sair"));
            System.out.println("Cliente desconectado");
        }
        catch(IOException e){
            System.out.println("Falha na comunicação: "+e.getMessage());
        }
    }

    private static void iniciaCliente() throws IOException{
        client = new Socket(SimpleServerTest.HOST, SimpleServerTest.PORT);
        System.out.println("Cliente conectado ao servidor"+SimpleServerTest.HOST+":"+SimpleServerTest.PORT);
    }
    private static void enviarMensagem(String msg) throws IOException{
        PrintStream ps = new PrintStream(client.getOutputStream());
        ps.println(msg);
    }
    
}

