import java.io.IOException;
import java.net.ServerSocket;

public class LocalPortScanner {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket server = new ServerSocket(9090);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
