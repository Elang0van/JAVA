package Chats;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import javax.swing.JTextField;

public class elango extends Frame implements Runnable, ActionListener{
    TextField textField;
    TextArea textArea;
    Button send;

    Socket socket;

    DataOutputStream dataOutputStream;

    DataInputStream dataInputStream;

    Thread chat;

    elango(){
        textField=new TextField();
        textArea=new TextArea();
        send=new Button("send"); 

        send.addActionListener(this);
        try{
        socket=new Socket("localhost",6666);

        dataInputStream=new DataInputStream(socket.getInputStream());
        dataOutputStream=new DataOutputStream(socket.getOutputStream());
        }
        catch(Exception e){
            System.out.println("IP Not found");
        }

       
       add(textArea);
       add(textField);
       add(send);
        
        chat = new Thread(this);
        chat.setDaemon(true);
        chat.start();
        textField.setPreferredSize(new Dimension(200,100));
        setSize(500,500);
        setTitle("Elango");
        setLayout(new FlowLayout());
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String msg=textField.getText();
       textArea.append("                                                                     elango : "+msg+"\n");
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
        new elango();
    }

    @Override
    public void run() {
             while(true){
          try {
            String msg=dataInputStream.readUTF();
            textArea.append("anju : "+msg+ "\n");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        }
    }
}
