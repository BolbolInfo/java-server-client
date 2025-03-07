import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 8080);
            System.out.println("Connected to server on port 8080");
            
            Scanner userInput = new Scanner(System.in); // For user input
            Scanner in = new Scanner(client.getInputStream()); // For server response
            PrintWriter out = new PrintWriter(client.getOutputStream(), true); // Auto-flush enabled

            // Thread to read server responses
            new Thread(() -> {
                while (in.hasNextLine()) {
                    System.out.println("\n" + in.nextLine());
                    System.out.print("--->");

                }
            }).start();

            // Sending user input to the server
            int i = 0;
            while (true) {
                System.out.println("Enter message: ");
                if (i==0){
                    System.out.print("--->");
                    i++;
                    
                }
                String message = userInput.nextLine();
                out.println(message);
                if (message.equalsIgnoreCase("exit")) {
                    break; // Exit on user command
                }
            }

            // Cleanup
            client.close();
            userInput.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
