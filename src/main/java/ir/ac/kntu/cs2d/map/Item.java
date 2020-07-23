package ir.ac.kntu.cs2d.map;

import javafx.scene.shape.Rectangle;

public abstract class Item {
    private Rectangle shape;
    private boolean bulletCanPass;
    private boolean wall;

    public Item(Rectangle shape, boolean bulletCanPass, boolean wall) {
        this.shape = shape;
        this.bulletCanPass = bulletCanPass;
        this.wall = wall;
    }

    public Rectangle getShape() {
        return shape;
    }

    public void setShape(Rectangle shape) {
        this.shape = shape;
    }

    public boolean bulletCanPass() {
        return bulletCanPass;
    }

    public void setBulletCanPass(boolean bulletCanPass) {
        this.bulletCanPass = bulletCanPass;
    }

    public boolean isWall() {
        return wall;
    }

    public void setWall(boolean wall) {
        this.wall = wall;
    }
}
