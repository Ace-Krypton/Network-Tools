import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //Listening on port: 9090
        ServerSocket serverSocket = new ServerSocket(9090);
        System.out.println("Waiting for clients");

        //Listens until the connection is established
        Socket socket = serverSocket.accept();

        //Prints Data and autoFlush mode is on
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Hello Client");
        
        //It is for reading the data
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //For the client input
        String clientInput = input.readLine();
        System.out.println(clientInput);

        //Closing the Streams
        input.close();
        out.close();
        socket.close();
    }
}