import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
    public static void main(String[] args) throws SocketException {
        try {
            DatagramSocket socket = new DatagramSocket(9090);
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];

            while (true) {
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}