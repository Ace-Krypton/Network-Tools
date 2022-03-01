import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemotePortScanner {
    public static void main(String[] args) {
        //Create a Buffered reader that reads the user input
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        String targetIP = "";   //Store the IP address
        int fromPort = 0;       //Store the starting
        int toPort = 0;         //Store the ending

        System.out.println("Please enter the target IP address -> ");   //Ask user to enter the IP address

        try {
            targetIP = reader.readLine();  //Read the target IP address
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
