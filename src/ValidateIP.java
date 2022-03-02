import org.apache.commons.validator.routines.InetAddressValidator;
public class ValidateIP {
    /**
     *                 Valid IP address:
     *                 192.168.0.12
     *                 10.10.10.10
     *                 86.123.6.230
     *
     *                 Invalid IP address
     *                 192.168.0.321
     *                 10.10.10.10.10
     *                 232.0.0.ac
     */

    public static void main(String[] args) {
        InetAddressValidator validator = new InetAddressValidator();
        String ipAddress = "192.168.0.10";
        boolean isValid = validator.isValid(ipAddress);

        if (isValid) System.out.println(ipAddress + " is valid");
        else System.out.println(ipAddress + " is not valid");

        System.out.println(validateIpAddress("192.168.1.2"));
        if (validateIpAddress("192.121.212.355")) System.out.println("It is valid");
        else System.out.println("It is not valid");
    }

    public static boolean validateIpAddress(String ipAddress) {
        String[] numbers = ipAddress.split("\\.");
        if (numbers.length != 4) return false;
        for (String str : numbers) {
            int i = Integer.parseInt(str);
            if ((i < 0) || (i > 255)) return false;
        }
        return true;
    }
}
