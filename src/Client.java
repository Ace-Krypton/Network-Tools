import java.io.*;
import java.net.Inet4Address;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        try {
            int port = 9090;
            Inet4Address serverAddress = (Inet4Address) Inet4Address.getByName("localhost");
            System.out.println("Server IP address -> " + Arrays.toString(serverAddress.getAddress()));
            Socket socket = new Socket(serverAddress, port);
            PrintWriter output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(input.readLine());
            output.println("Hello Server!");
            close(socket, input, output);

        } catch (UnknownHostException u) {
            System.out.println("Unknown Host Exception -> " + u);
        } catch (IOException i) {
            System.out.println("IO Exception -> " + i);
        } catch (IllegalArgumentException il) {
            System.out.println("Illegal Argument Exception -> " + il);
        } catch (Exception e) {
            System.out.println("Other Exception -> " + e);
        }
    }

    public static void close(Socket socket, BufferedReader input, PrintWriter output) throws IOException {
        input.close();
        output.close();
        socket.close();
    }
}
