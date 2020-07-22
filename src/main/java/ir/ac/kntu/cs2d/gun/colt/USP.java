package ir.ac.kntu.cs2d.gun.colt;

import ir.ac.kntu.cs2d.gun.Gun;
import ir.ac.kntu.cs2d.player.Player;

public class USP extends Gun {
    public USP(Player owner) {
        super(owner, 500, 24, 340, 2.2, 12, true, 1);
    }
}
