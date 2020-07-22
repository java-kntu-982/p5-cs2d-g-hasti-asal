package ir.ac.kntu.cs2d.player;

import ir.ac.kntu.cs2d.gun.Gun;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public class CounterTerrorist extends Player {
    public CounterTerrorist(double x, double y) {
        super(x, y, 100, new ArrayList<>(), new Circle(5));
    }

    @Override
    public void run() {
        while (isAlive()) {
            setX(getShape().getCenterX());
            setY(getShape().getCenterY());
            try {
                getCurGun().setX(getX());
                getCurGun().setY(getY());
                getCurGun().getBullets().forEach(bullet -> {
                    bullet.setX(getX());
                    bullet.setY(getY());
                });
            } catch (NullPointerException ignored) {}
        }
    }
}
