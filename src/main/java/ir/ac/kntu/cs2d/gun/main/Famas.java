package ir.ac.kntu.cs2d.gun.main;

import ir.ac.kntu.cs2d.gun.Gun;
import ir.ac.kntu.cs2d.player.Player;

public class Famas extends Gun {
    public Famas(Player owner) {
        super(owner,2250, 14, 120, 3.3, 25, false, 2);
    }
}
