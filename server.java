import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server{
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is running on port 8080");
        while (true) {
            try (Socket client = server.accept()) {
                
                System.out.println("Client connected");
            }
        }     
    }
}