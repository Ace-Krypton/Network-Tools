import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090); //Listening on port: 9090
        System.out.println("Waiting for clients");
        Socket socket = serverSocket.accept();  //Listens until the connection is established

    }
}
