package ir.ac.kntu.cs2d.map.item;

import ir.ac.kntu.cs2d.map.Item;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Brown extends Item {
    public Brown(Rectangle shape) {
        super(shape, false, false);
        shape.setFill(Color.BROWN);
    }
}
