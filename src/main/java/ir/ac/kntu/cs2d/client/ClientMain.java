package ir.ac.kntu.cs2d.client;

import java.io.*;
import java.net.Socket;

public class ClientMain {
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    public static void main(String[] args) throws IOException {
        ClientMain client = new ClientMain();
    }

    private ClientMain() throws IOException {
        socket = new Socket("localhost", 50128);
        in = new ObjectInputStream(socket.getInputStream());
        out = new ObjectOutputStream(socket.getOutputStream());
    }

    public void sendData(Object o) {
        try {
            out.writeObject(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object receiveData() {
        try {
            return in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public ObjectInputStream getIn() {
        return in;
    }

    public void setIn(ObjectInputStream in) {
        this.in = in;
    }

    public ObjectOutputStream getOut() {
        return out;
    }

    public void setOut(ObjectOutputStream out) {
        this.out = out;
    }
}
