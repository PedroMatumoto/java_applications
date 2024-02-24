import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;
public class SimpleServerTest {
    public static final String HOST = "127.0.0.1";
    public static final int PORT = 3334;

    public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Servidor iniciado na porta " + PORT);
            Socket client = server.accept();
            System.out.println("Cliente conectado do IP " + client.getInetAddress().getHostAddress()+ "Conectado");
            Scanner s = new Scanner(client.getInputStream());
            System.out.println("Mensagem do cliente: ");
            while(s.hasNextLine()){
                System.out.println(s.nextLine());
            }
            System.out.println("Cliente desconectado");
            s.close();
            server.close();
        } catch (IOException e){
            System.out.println("Erro ao criar o servidor");
        }
    } 
}