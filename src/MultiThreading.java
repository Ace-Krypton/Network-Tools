import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreading {
    public static void main(String[] args) {
        try {
            //Listening on port: 9090
            ServerSocket serverSocket = new ServerSocket(9090);   //Request Waiting, Step 1

            //Boolean variable for stopping the loop
            boolean stop = false;

            //Loop for waiting another client
            while (!stop) {
                //Informative
                System.out.println("Waiting for the clients...");
                //Accepting connections from client side
                Socket clientSocket = serverSocket.accept();    //Process State, Step 2
                //Informative
                System.out.println("Client is connected");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
