import java.io.*;
import java.net.*;

public class InetAddress {
    public static void main(String[] args) {
        try {
            //Getting the Hostname and IP address of the Local Host
            Inet4Address address = (Inet4Address) Inet4Address.getLocalHost();
            System.out.println(address.getHostAddress());
            System.out.println(address.getHostName());

            //Getting the IP and Hostname of website
            Inet4Address scan = (Inet4Address) Inet4Address.getByName("google.com");
            System.out.println(scan.getHostAddress());
            System.out.println(scan.getHostName());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
