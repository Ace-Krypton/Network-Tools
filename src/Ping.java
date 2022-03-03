import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.UnknownHostException;

public class Ping {
    public static void main(String[] args) {
        try {
            String hostAddress = "google.com";
            Inet4Address host = (Inet4Address) Inet4Address.getByName(hostAddress);
            System.out.println(host.isReachable(1000)); //In Linux Systems, If you run this with a root, it will work
            Process p = Runtime.getRuntime().exec("ping " + hostAddress);
            Process c = Runtime.getRuntime().exec("pwd");
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));

            String command = in.readLine();
            System.out.println(command);

            String commandOutput;
            boolean isReachable = true;
            //Reading the output stream of the command
            while ((commandOutput = inputStream.readLine()) != null) {
                System.out.println(commandOutput);

                if (commandOutput.contains("Destination host unreachable")) {
                    isReachable = false;
                    break;
                }
            }
            if (isReachable) System.out.println("Host is reachable");
            else System.out.println("Host is unreachable");
        } catch (UnknownHostException u) {
            System.out.println("Unknown Host Exception -> " + u);
        } catch (IOException i) {
            System.out.println("Something -> " + i);
        }
    }
}
