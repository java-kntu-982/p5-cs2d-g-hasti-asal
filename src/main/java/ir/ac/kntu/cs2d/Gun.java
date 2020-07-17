package ir.ac.kntu.cs2d;

public class Gun {
    private int price,damage,millisToFireAgain,magazineCapacity;
    private double secToReload;

    public Gun(int price, int damage, int millisToFireAgain,double secToReload , int magazineCapacity) {
        this.price = price;
        this.damage = damage;
        this.millisToFireAgain = millisToFireAgain;
        this.secToReload = secToReload;
        this.magazineCapacity = magazineCapacity;
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
