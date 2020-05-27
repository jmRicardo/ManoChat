package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server implements Runnable {

    private int port;
    private ServerSocket server;
    private boolean running;

    static List<ClientThread> clients = new ArrayList<ClientThread>();

    public Server(int port) {
        this.port = port;
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No se pudo iniciar el Servidor en el puerto > "+port);
        }
        running = true;
        this.run();
    }

    @Override
    public void run() {
        while (running){
            acceptClients();
        }
    }

    private void acceptClients(){
        try {
            System.out.println("Esperando nuevo Cliente...");
            Socket socket = server.accept();
            System.out.println("Nuevo Cliente >>> " + socket.toString());
            ClientThread cThread = new ClientThread(socket);
            Thread thread = new Thread(cThread);
            thread.start();
            clients.add(cThread);
        } catch (IOException e) {
            e.printStackTrace();
            running = false;
        }

    }
}
