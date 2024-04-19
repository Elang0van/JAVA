package Chats;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class anju extends Frame implements Runnable, ActionListener{
    TextField textField;
    TextArea textArea;
    Button send;
 
    ServerSocket serverSocket;
    Socket socket;

    DataOutputStream dataOutputStream;

    DataInputStream dataInputStream;

    Thread chat;

    anju(){
        textField=new TextField();
        textArea=new TextArea();
        send=new Button("send"); 

        send.addActionListener(this);
        try{
        serverSocket=new ServerSocket(6666);
        socket=serverSocket.accept();

        dataInputStream=new DataInputStream(socket.getInputStream());
        dataOutputStream=new DataOutputStream(socket.getOutputStream());
        }
        catch(Exception e){
         System.out.println("Incorrect port number");
        }
       
        add(textArea);
        add(textField);
        add(send);
        
        chat = new Thread(this);
        chat.setDaemon(true);
        chat.start();
        textField.setPreferredSize(new Dimension(200,100));
        setSize(500,500);
        setTitle("anju");
        setLayout(new FlowLayout());
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String msg=textField.getText();
       textArea.append("                                                                       anju : "+msg+"\n");
       textField.setText("");

       try {
        dataOutputStream.writeUTF(msg);
        dataOutputStream.flush();
    } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }
    }

    
    public static void main(String[] args) {
        new anju();
    }

    @Override
    public void run() {
             while(true){
          try {
            String msg=dataInputStream.readUTF();
            textArea.append("elango : "+msg+ "\n");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        }
    }
}

