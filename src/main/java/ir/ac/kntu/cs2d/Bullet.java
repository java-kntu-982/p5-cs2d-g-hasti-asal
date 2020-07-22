package ir.ac.kntu.cs2d;

import ir.ac.kntu.cs2d.map.Map;
import ir.ac.kntu.cs2d.player.CounterTerrorist;
import ir.ac.kntu.cs2d.player.Player;
import ir.ac.kntu.cs2d.player.Terrorist;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Bullet implements Runnable {
    private double x;
    private double y;
    private double dx = 0;
    private double dy = 0;
    private Player owner;
    private Circle shape;
    private boolean hit = false;
    private boolean shot = false;
    private Map map;
    private List<CounterTerrorist> ct;
    private List<Terrorist> t;

    public Bullet(Player owner) {
        x = owner.getX();
        y = owner.getY();
        this.owner = owner;
        shape = new Circle(x, y, 1);
    }

    public void setXY() {
        if (hit) {
            x = owner.getX();
            y = owner.getY();
        }
    }

    public void shoot() {
        shot = true;
        switch (owner.getDirection()) {
            case 1:
                dy = -15;
                break;
            case 2:
                dy = 15;
                break;
            case 3:
                dx = -15;
                break;
            case 4:
                dx = 15;
                break;
            default:
        }
    }

    public void move(Map map, List<CounterTerrorist> ct, List<Terrorist> t) {
        shape.setCenterX(shape.getCenterX() + dx);
        shape.setCenterY(shape.getCenterY() + dy);
        if (didHit(map, ct, t)) {
            dx = 0;
            dy = 0;
            hit = true;
        }
    }

    public boolean didHit(Map map, List<CounterTerrorist> ct, List<Terrorist> t) {
        List<Rectangle> things = new ArrayList<>();
        map.getCreamWalls().forEach(cream -> things.add(cream.getShape()));
        map.getOrangeWalls().forEach(orange -> things.add(orange.getShape()));
        map.getBrownBoxes().forEach(brown -> things.add(brown.getShape()));
        map.getGrayBoxes().forEach(gray -> things.add(gray.getShape()));
        for (Rectangle r: things) {
            if (r.getBoundsInParent().intersects(shape.getBoundsInParent())) {
                return true;
            }
        }
        final boolean[] ans = {false};
        ct.forEach(counterTerrorist -> {
            if (counterTerrorist.getShape().getBoundsInParent().intersects(shape.getBoundsInParent())) {
                ans[0] = true;
                counterTerrorist.gotHit();
            }
        });
        if (ans[0]) {
            t.forEach(terrorist -> {
                if (terrorist.getShape().getBoundsInParent().intersects(shape.getBoundsInParent())) {
                    ans[0] = true;
                    terrorist.gotHit();
                }
            });
        }
        return ans[0];
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Circle getShape() {
        return shape;
    }

    public void setShape(Circle shape) {
        this.shape = shape;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public boolean isShot() {
        return shot;
    }

    public void setShot(boolean shot) {
        this.shot = shot;
    }

    @Override
    public void run() {
        while (!hit) {
            x += dx;
            y += dy;
            shape.setCenterX(x);
            shape.setCenterY(y);
        }
    }
}
