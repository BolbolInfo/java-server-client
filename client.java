import java.io.IOException;
import java.net.Socket;

public class client {
    public static void main(String[] args) throws IOException{
        Socket client = new Socket("localhost", 8080);
        System.out.println("Connected to server on port 8080");
        client.close();
    }
}
