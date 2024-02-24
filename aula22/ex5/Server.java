package ex5;
import java.net.ServerSocket;
import java.io.IOException;


public class Server {
    public static final String ADRESS = "localhost";
    public static final int PORT = 4000;
    private ServerSocket serverSocket;

    public void start() throws IOException {
        serverSocket = new ServerSocket(PORT);
        System.out.printf("Servidor iniciado em %s:%d\n", ADRESS, PORT);
        clientConnectionLoop();
    }

    private void clientConnectionLoop() throws IOException {
        System.out.println("Aguardando conexao de clientes...");
        do{
            ClientSocket clientSocket = new ClientSocket(serverSocket.accept());
            new Thread(() -> clientMessageLoop(clientSocket)).start();
        }
        while(true);
    }

    private void clientMessageLoop(ClientSocket clientSocket){
        String msg;
        try{
            while((msg = clientSocket.getMessage()) != null && !msg.equalsIgnoreCase("exit")){
                System.out.printf("Mensagem recebida de %s: %s\n", clientSocket.getRemoteSocketAdress(), msg);
            }
        }
        finally{
            clientSocket.close();
        }
    }

    public static void main(String[] args){
        System.out.println("Iniciando servidor...");
        try{
            Server server = new Server();
            server.start();
        }
        catch(IOException e){
            System.out.println("Erro ao iniciar servidor: "+e.getMessage());
        }
        System.out.println("Servidor finalizado");
    }
    
}
