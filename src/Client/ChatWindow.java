package Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ChatWindow extends JFrame{
    private JTextArea textChat;
    private JPanel rootWindow;
    private JTextField textInput;
    private JButton buttonSend;

    private String name;
    private String address;
    private int port;

    private Socket socket;
    private InetAddress ip;

    private DataOutputStream outServer = null;
    private DataInputStream inServer = null;

    private Thread recieve;


    public ChatWindow(String name,String address,int port){

        /// variables

        this.name = name;
        this.address = address;
        this.port = port;

        /// visual
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        add(rootWindow);
        setSize(800,640);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("ManoChat");
        setVisible(true);
        textInput.requestFocus();

        textInput.addActionListener(new actions());
        buttonSend.addActionListener(new actions());

        /// conexion
        connect(address,port);

        recieve();
    }

    private void recieve(){
        recieve = new Thread("Recieve"){
            public void run(){
                while (true){
                    console(recieveMsg());
                }
            }
        };
        recieve.start();
    }

    private void connect(String address,int port)
    {
        try {
            socket = new Socket(address,port);
            outServer = new DataOutputStream(socket.getOutputStream());
            inServer = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    class actions implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String msg = textInput.getText();
            if (!msg.equals(""))
            {
                textInput.setText("");
                String msgFormat = name + " >>> " + msg;
                console(msgFormat);
                sendMsg(msgFormat);
            }
        }
    }
    private void sendMsg(String msg){
        try {
            outServer.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String recieveMsg(){
        String msg = null;
        try {
            msg = inServer.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }

    private void console(String msg)
    {
        textChat.append(msg + "\n\r");
    }

}
