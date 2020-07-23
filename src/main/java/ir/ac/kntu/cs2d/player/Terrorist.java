package ir.ac.kntu.cs2d.player;

import ir.ac.kntu.cs2d.gun.Gun;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public class Terrorist extends Player {
    private boolean hastBomb;

    public Terrorist(double x, double y) {
        super(x, y, 100, new ArrayList<>(), new Circle(5));
    }

    @Override
    public void run() {

    }
}
