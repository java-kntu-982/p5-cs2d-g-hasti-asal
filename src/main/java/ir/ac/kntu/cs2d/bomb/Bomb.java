package ir.ac.kntu.cs2d.bomb;

import ir.ac.kntu.cs2d.player.Terrorist;
import javafx.scene.shape.Rectangle;

public class Bomb {
    private Rectangle shape;
    private double x;
    private double y;
    private Terrorist owner;

    public Bomb(Terrorist owner) {
        this.owner = owner;
        shape = new Rectangle(5, 5);
        if (owner != null) {
            shape.setX(owner.getX());
            shape.setY(owner.getY());
        }
    }

    public void setXY() {
        if (!isInSite() || owner != null) {
            x = owner.getShape().getCenterX();
            y = owner.getShape().getCenterY();
            shape.setX(x);
            shape.setY(y);
        }
    }

    public boolean isInSite() {
        Rectangle a = new Rectangle(700/25, 700/3 - 700/12 - 700/14 - 700/16, 800/8 + 700/100, 700/14 - 700/100);
        Rectangle b = new Rectangle(700/25, 700/25. + 700/2.5 + 700/5. + 700/15, 800/10, 700/9);
        boolean ans = false;
        if (a.getBoundsInParent().intersects(shape.getBoundsInParent())) {
            ans = true;
        } else if (b.getBoundsInParent().intersects(shape.getBoundsInParent())) {
            ans = true;
        }
        return ans;
    }

    public Rectangle getShape() {
        return shape;
    }

    public void setShape(Rectangle shape) {
        this.shape = shape;
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

    public Terrorist getOwner() {
        return owner;
    }

    public void setOwner(Terrorist owner) {
        this.owner = owner;
    }
}
