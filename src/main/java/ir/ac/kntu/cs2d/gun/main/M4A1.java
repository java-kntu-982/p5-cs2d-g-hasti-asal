package ir.ac.kntu.cs2d.gun.main;

import ir.ac.kntu.cs2d.gun.Gun;
import ir.ac.kntu.cs2d.player.Player;

public class M4A1 extends Gun {
    public M4A1(Player owner) {
        super(owner,3100, 22, 120, 3.1, 30, false, 2);
    }
}
