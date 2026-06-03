package Assignment.Day5;


import java.util.logging.Logger;
import java.util.regex.Pattern;

class InvalidIPException extends Exception {
    public InvalidIPException(String message) {
        super(message);
    }
}

public class IPv4Validator {

    private static final Logger logger =
            Logger.getLogger(IPv4Validator.class.getName());

    private static final String IPV4_REGEX =
            "^((25[0-5]|2[0-4][0-9]|1?[0-9]{1,2})\\.){3}"
            + "(25[0-5]|2[0-4][0-9]|1?[0-9]{1,2})$";

    public static void validateIP(String ip)
            throws InvalidIPException {

        if (!Pattern.matches(IPV4_REGEX, ip)) {
            logger.severe("Invalid IP Address: " + ip);
            throw new InvalidIPException(
                    "Invalid IPv4 Address: " + ip);
        }

        logger.info("Valid IP Address: " + ip);
    }

    public static void main(String[] args) {

        String ip = "192.168.1.1";

        try {
            validateIP(ip);
            System.out.println("IP is valid");
        }
        catch (InvalidIPException e) {
            System.out.println(e.getMessage());
        }
    }
}