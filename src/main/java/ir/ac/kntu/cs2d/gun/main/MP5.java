package ir.ac.kntu.cs2d.gun.main;

import ir.ac.kntu.cs2d.gun.Gun;
import ir.ac.kntu.cs2d.player.Player;

public class MP5 extends Gun {
    public MP5(Player owner) {
        super(owner,1500, 13, 120, 3.1, 30, false, 1);
    }
}
