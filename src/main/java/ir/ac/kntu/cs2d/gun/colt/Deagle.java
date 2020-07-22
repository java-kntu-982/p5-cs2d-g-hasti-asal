package ir.ac.kntu.cs2d.gun.colt;

import ir.ac.kntu.cs2d.gun.Gun;
import ir.ac.kntu.cs2d.player.Player;

public class Deagle extends Gun {
    public Deagle(Player owner) {
        super(owner,650, 34, 550, 2.2, 7, true, 1);
    }
}
