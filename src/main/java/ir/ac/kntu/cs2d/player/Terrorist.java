package ir.ac.kntu.cs2d.player;

import ir.ac.kntu.cs2d.bomb.Bomb;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Terrorist extends Player {
    private boolean hasBomb;
    private Bomb bomb;

    public Terrorist(double x, double y) {
        super(x, y, 100, new ArrayList<>(), new Circle(5));
    }

    public void dropBomb(Scene scene) {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.DIGIT4) {
                    bomb.setOwner(null);
                }
            }
        });
    }

    @Override
    public void run() {

    }
}
