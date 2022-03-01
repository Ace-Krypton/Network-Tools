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
        } catch (Exception e) { //Error when trying to read user input
            System.out.println("Cannot read the IP address!" + e);
        }

        //Boolean value which is used to control the validation process
        boolean isValid = false;

        //As long as isValid false, it will try to obtain a valid port number
        while (isValid) {
            try {
                System.out.println("Please enter the first port -> ");  //Ask user to type the first port
                String portString = reader.readLine();  //Read the port number
                fromPort = Integer.parseInt(portString);  //Try to convert String to Integer
                
            } catch (NumberFormatException n) {
                System.out.println("Number Format Exception -> " + n);
            }
        }

    }
}
