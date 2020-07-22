package ir.ac.kntu.cs2d;

import ir.ac.kntu.cs2d.gun.Gun;
import ir.ac.kntu.cs2d.map.Map;
import ir.ac.kntu.cs2d.player.CounterTerrorist;
import ir.ac.kntu.cs2d.player.Terrorist;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<CounterTerrorist> ct;
    private List<Terrorist> t;
    private Map map;
    private List<Gun> guns;
    private List<Bullet> bullets;

    public Game(Map map) {
        ct = new ArrayList<>();
        t = new ArrayList<>();
        guns = new ArrayList<>();
        bullets = new ArrayList<>();
        this.map = map;
    }

    public List<CounterTerrorist> getCt() {
        return ct;
    }

    public void setCt(List<CounterTerrorist> ct) {
        this.ct = ct;
    }

    public List<Terrorist> getT() {
        return t;
    }

    public void setT(List<Terrorist> t) {
        this.t = t;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public List<Gun> getGuns() {
        return guns;
    }

    public void setGuns(List<Gun> guns) {
        this.guns = guns;
    }

    public List<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(List<Bullet> bullets) {
        this.bullets = bullets;
    }
}
