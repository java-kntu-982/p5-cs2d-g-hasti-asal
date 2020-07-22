package ir.ac.kntu.cs2d.gun.main;

import ir.ac.kntu.cs2d.gun.Gun;
import ir.ac.kntu.cs2d.player.Player;

public class Galil extends Gun {
    public Galil(Player owner) {
        super(owner,2000, 13, 120, 2.6, 35, false, 3);
    }
}
