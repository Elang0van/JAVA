package Socket;
import java.io.*;
import java.io.IOException;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(6666);
        Socket s= ss.accept();
        
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        dout.writeUTF("hello client");
        dout.close();
        dout.flush();
    }
}