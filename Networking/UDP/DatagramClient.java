package UDP;

import java.io.IOException;
import java.net.*;

public class DatagramClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket=new DatagramSocket(6666);
        byte[] buffer=new byte[1024];

        DatagramPacket datagramPacket=new DatagramPacket(buffer, 1024);
        
        datagramSocket.receive(datagramPacket);
        
        String msg=new String(datagramPacket.getData());

        System.out.println(msg);
        datagramSocket.close();
         
    }
}
