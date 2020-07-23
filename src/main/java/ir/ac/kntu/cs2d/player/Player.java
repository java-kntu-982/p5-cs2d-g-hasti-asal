package ir.ac.kntu.cs2d.player;

import ir.ac.kntu.cs2d.gun.Gun;
import ir.ac.kntu.cs2d.map.Map;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public abstract class Player implements Runnable{
    private String name;
    private double x;
    private double y;
    private double health;
    private List<Gun> guns;
    private Gun curGun;
    private int direction; // up:1 down:2 right:3 left:4
    private Circle shape;
    private boolean alive;

    public Player(double x, double y, double health, List<Gun> guns, Circle shape) {
        this.x = x;
        this.y = y;
        this.health = health;
        this.guns = guns;
        this.shape = shape;
        shape.setCenterX(x);
        shape.setCenterY(y);
        alive = true;
    }

    public void move(Scene scene, Map map) {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.W && canGoUpOrDown(map, -1)) {
                    shape.setCenterY(shape.getCenterY() - 1);
                    try {
                        curGun.getShape().setStartY(shape.getCenterY());
                        curGun.getShape().setStartX(shape.getCenterX());
                        curGun.getShape().setEndY(shape.getCenterY() - 10);
                        curGun.getShape().setEndX(shape.getCenterX());
                        curGun.getBullets().forEach(bullet -> {
                            if (!bullet.isShot() || bullet.isHit()) {
                                bullet.getShape().setCenterX(shape.getCenterX());
                                bullet.getShape().setCenterY(shape.getCenterY());
                            }
                        });
                        direction = 1;
                    } catch (NullPointerException ignored) {}
                } else if (keyEvent.getCode() == KeyCode.S && canGoUpOrDown(map, 1)) {
                    shape.setCenterY(shape.getCenterY() + 1);
                    try {
                        curGun.getShape().setStartY(shape.getCenterY());
                        curGun.getShape().setStartX(shape.getCenterX());
                        curGun.getShape().setEndY(shape.getCenterY() + 10);
                        curGun.getShape().setEndX(shape.getCenterX());
                        curGun.getBullets().forEach(bullet -> {
                            if (!bullet.isShot() || bullet.isHit()) {
                                bullet.getShape().setCenterX(shape.getCenterX());
                                bullet.getShape().setCenterY(shape.getCenterY());
                            }
                        });
                        direction = 2;
                    } catch (NullPointerException ignored) {}
                } else if (keyEvent.getCode() == KeyCode.A && canGoLeftOrRight(map, -1)) {
                    shape.setCenterX(shape.getCenterX() - 1);
                    try {
                        curGun.getShape().setStartX(shape.getCenterX());
                        curGun.getShape().setStartY(shape.getCenterY());
                        curGun.getShape().setEndX(shape.getCenterX() - 10);
                        curGun.getShape().setEndY(shape.getCenterY());
                        curGun.getBullets().forEach(bullet -> {
                            if (!bullet.isShot() || bullet.isHit()) {
                                bullet.getShape().setCenterX(shape.getCenterX());
                                bullet.getShape().setCenterY(shape.getCenterY());
                            }
                        });
                        direction = 3;
                    } catch (NullPointerException ignored) {}
                } else if (keyEvent.getCode() == KeyCode.D && canGoLeftOrRight(map, 1)) {
                    shape.setCenterX(shape.getCenterX() + 1);
                    try {
                        curGun.getShape().setStartX(shape.getCenterX());
                        curGun.getShape().setStartY(shape.getCenterY());
                        curGun.getShape().setEndX(shape.getCenterX() + 10);
                        curGun.getShape().setEndY(shape.getCenterY());
                        curGun.getBullets().forEach(bullet -> {
                            if (!bullet.isShot() || bullet.isHit()) {
                                bullet.getShape().setCenterX(shape.getCenterX());
                                bullet.getShape().setCenterY(shape.getCenterY());
                            }
                        });
                        direction = 4;
                    } catch (NullPointerException ignored) {}
                }
            }
        });
    }

    public void shoot(Scene scene) {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.SPACE) {
                    curGun.shoot();
                }
            }
        });
    }

    public void setXY() {
        x = shape.getCenterX();
        y = shape.getCenterY();
    }

    private boolean canGoUpOrDown(Map map, int d) {
        shape.setCenterY(shape.getCenterY() + d);
        boolean ans = canMove(map);
        shape.setCenterY(shape.getCenterY() - d);
        return ans;
    }

    private boolean canGoLeftOrRight(Map map, int d) {
        shape.setCenterX(shape.getCenterX() + d);
        boolean ans = canMove(map);
        shape.setCenterX(shape.getCenterX() - d);
        return ans;
    }

    private boolean canMove(Map map) {
        boolean ans = true;
        List<Rectangle> things = new ArrayList<>();
        map.getCreamWalls().forEach(cream -> things.add(cream.getShape()));
        map.getOrangeWalls().forEach(orange -> things.add(orange.getShape()));
        map.getGrayBoxes().forEach(gray -> things.add(gray.getShape()));
        map.getBrownBoxes().forEach(brown -> things.add(brown.getShape()));
        for (Rectangle r: things) {
            if (r.getBoundsInParent().intersects(shape.getBoundsInParent())) {
                ans = false;
            }
        }
        return ans;
    }

    public void gotHit() {
        if (health <= 0) {
            alive = false;
        }
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

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public List<Gun> getGuns() {
        return guns;
    }

    public void setGuns(List<Gun> guns) {
        this.guns = guns;
    }

    public Circle getShape() {
        return shape;
    }

    public void setShape(Circle shape) {
        this.shape = shape;
    }

    public Gun getCurGun() {
        return curGun;
    }

    public void setCurGun(Gun curGun) {
        this.curGun = curGun;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
