package ex5;
import java.io.IOException;
import java.net.Socket;
import java.io.PrintWriter;
import java.util.Scanner;


public class Client {
    private Socket clienSocket;
    private Scanner scanner;
    private PrintWriter saida;

    public Client(){
        scanner = new Scanner(System.in);
    }

    public void start() throws IOException {
        clienSocket = new Socket(Server.ADRESS, Server.PORT);
        saida = new PrintWriter(clienSocket.getOutputStream(), true);
        System.out.println("Cliente"+ Server.ADRESS +":"+ Server.PORT+" conectado");
        messageLoop();
    }

    private void messageLoop() throws IOException {
        String msg;
        System.out.println("Esperando mensagem:");
        do{
            System.out.print("Digite uma mensagem ou <exit>: ");
            msg = scanner.nextLine();
            saida.println(msg);
        }
        while(!msg.equalsIgnoreCase("exit"));
    }

    public static void main(String[] args) {
        System.out.println("Iniciando cliente...");
        try{
            Client client = new Client();
            client.start();
        }
        catch(IOException e){
            System.out.println("Erro ao iniciar cliente: "+e.getMessage());
        }
        System.out.println("Cliente finalizado");
    }
    
}
