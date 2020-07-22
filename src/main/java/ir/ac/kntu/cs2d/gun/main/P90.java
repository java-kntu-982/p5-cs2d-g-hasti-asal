package ir.ac.kntu.cs2d.gun.main;

import ir.ac.kntu.cs2d.gun.Gun;
import ir.ac.kntu.cs2d.player.Player;

public class P90 extends Gun {
    public P90(Player owner) {
        super(owner,2350, 11, 80, 3.3, 50, false, 1);
    }
}
