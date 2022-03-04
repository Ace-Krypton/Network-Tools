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

        /*  If everything has been initialized then we want to write some data
         *  to the socket we have opened a connection to on port 25
         * */

        if (smtpSocket != null && out != null && in != null) {
            try {
                /*
                STEP 1 -> Get a greeting by the server
                 */
                String responseLine;
                while ((responseLine = in.readLine()) != null) {
                    System.out.println("Server -> " + responseLine);
                    if (responseLine.contains("220")) break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
