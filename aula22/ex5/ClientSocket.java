package ex5;
import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;

import javax.imageio.IIOException;

public class ClientSocket {
    private final Socket socket;
    private final BufferedReader in;
    private final PrintWriter out;

    public ClientSocket(final Socket socket) throws IOException{
        this.socket = socket;
        System.out.println("Cliente conectado: "+socket.getRemoteSocketAddress()+" se conectou");
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    public SocketAddress getRemoteSocketAdress(){
        return socket.getRemoteSocketAddress();
    }

    public String getMessage(){
        try{
            return in.readLine();
        }
        catch(IOException e){
            System.out.println("Erro ao ler mensagem do cliente: "+e.getMessage());
            return null;
        }
    }

    public boolean sendMessage(String msg){
        out.println(msg);
        return !out.checkError();
    }

    public void close(){
        try{
            in.close();
            out.close();
            socket.close();
        }
        catch(IOException e){
            System.out.println("Erro ao fechar socket: "+e.getMessage());
        }
    }
    
}
