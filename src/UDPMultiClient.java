import java.io.IOException;
import java.net.*;

public class UDPMultiClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket clientSocket = new DatagramSocket();
        Inet4Address IPAddress = (Inet4Address) Inet4Address.getByName("localhost");
        byte[] sendData;
        boolean stop = false;

        while (!stop) {
            String stringSendData = "Client Text Message";
            sendData = stringSendData.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9090);
            clientSocket.send(sendPacket);
        }
        clientSocket.close();
    }
}
