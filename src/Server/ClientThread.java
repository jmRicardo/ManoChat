package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static Server.Server.clients;

public class ClientThread implements Runnable{

    private DataInputStream inputClient;
    private DataOutputStream outClient;
    private Socket socket;

    public ClientThread(Socket socket) {
        this.socket = socket;
        try {
            inputClient = new DataInputStream(socket.getInputStream());
            outClient = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true){
            String msg = recieveMsg();
            System.out.println(msg);
            sendMsg(msg);
        }
    }

    public DataOutputStream getOutClient() {
        return outClient;
    }

    private void sendMsg(String msg){
        for (ClientThread c:clients)
        {
            try {
                c.getOutClient().writeUTF(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String recieveMsg(){
        String msg = null;
        try {
            msg = inputClient.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }
}
