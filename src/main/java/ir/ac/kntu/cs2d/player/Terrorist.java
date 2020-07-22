package ir.ac.kntu.cs2d.player;

import ir.ac.kntu.cs2d.gun.Gun;
import javafx.scene.shape.Circle;

import java.util.List;

public class Terrorist extends Player {
    private boolean hastBomb;

    public Terrorist(double x, double y, double health, List<Gun> guns, Circle shape) {
        super(x, y, health, guns, shape);
    }

    @Override
    public void run() {

    }
}
