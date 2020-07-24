package ir.ac.kntu.cs2d.gun;

import ir.ac.kntu.cs2d.Bullet;
import ir.ac.kntu.cs2d.player.CounterTerrorist;
import ir.ac.kntu.cs2d.player.Player;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.List;

public abstract class Gun {
    private double x;
    private double y;
    private int price;
    private int damage;
    private int millisToFireAgain;
    private int magazineCapacity;
    private double secToReload;
    private boolean colt;
    private int canBuy;
    private int curShots;
    private Line shape;
    private Player owner;
    private List<Bullet> bullets;

    public Gun(Player owner, int price, int damage, int millisToFireAgain,double secToReload , int magazineCapacity, boolean colt, int canBuy) {
        this.x = owner.getX();
        this.y = owner.getY();
        this.price = price;
        this.damage = damage;
        this.millisToFireAgain = millisToFireAgain;
        this.secToReload = secToReload;
        this.magazineCapacity = magazineCapacity;
        this.colt = colt;
        this.canBuy = canBuy;
        curShots = 0;
        shape = new Line(x, y, x, y - 10);
        this.owner = owner;
        owner.setDirection(1);
        bullets = new ArrayList<>();
        for (int i = 0; i < magazineCapacity; i++) {
            bullets.add(new Bullet(owner));
        }
    }

    public void setXY() {
        x = owner.getX();
        y = owner.getY();
    }

    public void shoot() {
        if (curShots < magazineCapacity) {
            bullets.get(curShots).shoot();
            curShots++;
        } else {
            curShots = 0;
            try {
                wait((long) (secToReload*1000));
            } catch (Exception ignored) {}
        }
    }

    public boolean canBuy(Player player) {
        if (player instanceof CounterTerrorist) {
            return canBuy == 2 || canBuy == 1;
        } else {
            return canBuy == 3 || canBuy == 1;
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMillisToFireAgain() {
        return millisToFireAgain;
    }

    public void setMillisToFireAgain(int millisToFireAgain) {
        this.millisToFireAgain = millisToFireAgain;
    }

    public int getMagazineCapacity() {
        return magazineCapacity;
    }

    public void setMagazineCapacity(int magazineCapacity) {
        this.magazineCapacity = magazineCapacity;
    }

    public double getSecToReload() {
        return secToReload;
    }

    public void setSecToReload(double secToReload) {
        this.secToReload = secToReload;
    }

    public boolean isColt() {
        return colt;
    }

    public void setColt(boolean colt) {
        this.colt = colt;
    }

    public int getCanBuy() {
        return canBuy;
    }

    public void setCanBuy(int canBuy) {
        this.canBuy = canBuy;
    }

    public int getCurShots() {
        return curShots;
    }

    public void setCurShots(int curShots) {
        this.curShots = curShots;
    }

    public Line getShape() {
        return shape;
    }

    public void setShape(Line shape) {
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

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public List<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(List<Bullet> bullets) {
        this.bullets = bullets;
    }

    @Override
    public String toString() {
        return "Gun{" +
                "price=" + price +
                ", damage=" + damage +
                ", millisToFireAgain=" + millisToFireAgain +
                ", magazineCapacity=" + magazineCapacity +
                ", secToReload=" + secToReload +
                '}';
    }
}
