import java.net.*;

public class UDPClient {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket(0);
            byte[] sendData = new byte[1024];    //Store outgoing data
            byte[] receiveData = new byte[1024]; //Store incoming data
            //Amount of data = 65535 - 20 (IP Header) - 8 (UDP Header) = 65508

            Inet4Address serverAddress = (Inet4Address) Inet4Address.getByName("localhost");

            String stringSendData = "Hello Server";
            sendData = stringSendData.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9090);
            clientSocket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            receiveData = receivePacket.getData();
            String stringReceiveData = new String(receiveData);
            System.out.println("From Server -> " + stringSendData);
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
