package Server;

public class ServerMain {

    private int port;

    public ServerMain(int port)
    {
        this.port = port;
        new Server(port);
    }

    public static void main(String[] args) {

        int port = 6666;
        /// en un futuro voy a enviar el puerto por commando y esto va a servir
        /*try{
            port = Integer.parseInt(args[0]);
            new ServerMain(port);
        }catch (NumberFormatException e)
        {
            System.out.println("Formato de puerto equivocado");
        } */
        new ServerMain(port);

    }
}
