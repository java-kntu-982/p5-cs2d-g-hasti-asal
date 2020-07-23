package ir.ac.kntu.cs2d;

import ir.ac.kntu.cs2d.client.ClientMain;
import javafx.animation.AnimationTimer;

import java.net.Socket;
import java.util.List;

public class GameHandler implements Runnable {
    private Game game;
    private List<Socket> clients;

    public GameHandler(Game game, List<Socket> clients) {
        this.game = game;
        this.clients = clients;
    }

    @Override
    public void run() {
        while (true) {
//            clients.forEach(socket -> );
        }
    }
}
