import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

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
        while (!isValid) {
            try {
                System.out.println("Please enter the first port -> ");  //Ask user to type the first port
                String portString = reader.readLine();  //Read the port number
                fromPort = Integer.parseInt(portString);  //Try to convert String to Integer

                if (fromPort >= 0 && fromPort <= 65536) {  //Verify that port is in valid range
                    isValid = true;
                }
                else System.out.println("Invalid port!\nPort range is -> 0 - 65536");   //Inform the user about right port range
            } catch (NumberFormatException n) {
                System.out.println("Number Format Exception -> " + n);
            } catch (Exception e) {  //Error when trying to read user input
                System.out.println("Cannot Read The Port Number -> " + e);
            }
        }

        isValid = false;  //Reinitialize the boolean value to false in order to start a new validation process

        //As long as isValid is false, try to obtain a valid port number
        while (!isValid) {
            try {
                System.out.println("Enter The Last Port ->  "); //Ask user to type last port
                String portString = reader.readLine();  //Read the port number
                toPort = Integer.parseInt(portString);  //Try to convert String to Integer

                if (toPort >= 0 && toPort <= 65536) {   //Verify, if the toPort is greater than fromPort
                    if (toPort >= fromPort) {
                        isValid = true;  //Set the boolean to true and exit the while loop
                    }
                }
                else System.out.println("Invalid port!\nPort range is -> 0 - 65536");   //Inform the user about right port range
            } catch (NumberFormatException n) {
                System.out.println("Number Format Exception -> " + n);
            } catch (Exception e) {  //Error when trying to read user input
                System.out.println("Cannot Read The Port Number -> " + e);
            }
        }

        int port = fromPort; //Start with fromPort value

        while (port >= fromPort && port <= toPort) {  //Use the given port range
            try {
                Socket socket = new Socket(targetIP, port); //Try to open on socket connection using the specified IP address and Port
                System.out.println("Port " + port + " is in listening state");  //Print listening port
                socket.close();
            } catch (UnknownHostException u) {
                System.out.println("Unknown Host Exception -> " + u);
            } catch (IOException i) {
                System.out.println("IO Exception -> " + i);
            } catch (Exception e) {
                System.out.println("Other Exception -> " + e);
            }
            port++;
        }
    }
}
