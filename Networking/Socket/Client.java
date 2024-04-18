package Socket;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client{
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket s=new Socket("localhost",6666);
        
        DataInputStream dataInputStream=new DataInputStream(s.getInputStream());
        String msg=dataInputStream.readUTF();
        System.out.println("Server : "+msg);
        }
}