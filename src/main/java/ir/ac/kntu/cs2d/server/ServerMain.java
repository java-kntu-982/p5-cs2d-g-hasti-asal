package ir.ac.kntu.cs2d.server;

import ir.ac.kntu.cs2d.Game;
import ir.ac.kntu.cs2d.GameHandler;
import ir.ac.kntu.cs2d.map.Map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class ServerMain {
    private ServerSocket serverSocket = new ServerSocket(50128);
    private List<Socket> clients;
    private ObjectOutputStream out;
    private ObjectInputStream in;


    public static void main(String[] args) throws IOException {
        ServerMain server = new ServerMain();
        server.getClients().add(server.serverSocket.accept());

        GameHandler gameHandler = new GameHandler(new Game(new Map(700, 800)), server.clients);


    }

    private ServerMain() throws IOException {

    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public List<Socket> getClients() {
        return clients;
    }

    public void setClients(List<Socket> clients) {
        this.clients = clients;
    }

    public ObjectOutputStream getOut() {
        return out;
    }

    public void setOut(ObjectOutputStream out) {
        this.out = out;
    }

    public ObjectInputStream getIn() {
        return in;
    }

    public void setIn(ObjectInputStream in) {
        this.in = in;
    }

}
