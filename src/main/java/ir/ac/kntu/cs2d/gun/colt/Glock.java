package ir.ac.kntu.cs2d.gun.colt;

import ir.ac.kntu.cs2d.gun.Gun;
import ir.ac.kntu.cs2d.player.Player;

public class Glock extends Gun {
    public Glock(Player owner) {
        super(owner, 400, 21, 300, 2.3, 20, true, 1);
    }
}
