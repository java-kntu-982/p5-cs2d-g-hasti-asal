package ir.ac.kntu.cs2d.gun.main;

import ir.ac.kntu.cs2d.gun.Gun;
import ir.ac.kntu.cs2d.player.Player;

public class AK47 extends Gun {
    public AK47(Player owner) {
        super(owner,2500,22,120,2.5,30,false,3);
    }
}
