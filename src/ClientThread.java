import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {

    private Socket socket = null;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello Client");
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String clientInput = input.readLine();
            System.out.println(clientInput);
            close(input, out, socket);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close(BufferedReader input, PrintWriter out, Socket socket) throws IOException {
        input.close();
        out.close();
        socket.close();
    }
}
