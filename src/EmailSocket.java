import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EmailSocket {
    private static Socket smtpSocket;
    private static PrintWriter out;
    private static BufferedReader in;
    public static void main(String[] args) {
        /*  Initialization section
         *  Try to open a socket on port 25
         *  Try to open input and output streams
         * */

        try {
            smtpSocket = new Socket("localhost", 25);
            in = new BufferedReader(new InputStreamReader(smtpSocket.getInputStream()));
            out = new PrintWriter(smtpSocket.getOutputStream(), true);
        } catch (UnknownHostException u) {
            System.out.println("Unknown Host Exception -> " + u);
        } catch (IOException i) {
            System.out.println("IOException -> " + i);
        }

        //If everything 
    }
}
