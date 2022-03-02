import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;

public class NetworkInterface {
    public static void main(String[] args) {
        try {
            Inet4Address address = (Inet4Address) Inet4Address.getByName("google.com");
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(address);



        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
