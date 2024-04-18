import java.net.InetAddress;
import java.net.UnknownHostException;

public class name{
    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            String hostName = localHost.getHostName();
            System.out.println("Host Name: " + hostName);
        } catch (UnknownHostException e) {
            System.err.println("Unable to determine host name: " + e.getMessage());
        }
    }
}
