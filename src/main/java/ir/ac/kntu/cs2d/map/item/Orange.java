package ir.ac.kntu.cs2d.map.item;

import ir.ac.kntu.cs2d.map.Item;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Orange extends Item {
    public Orange(Rectangle shape) {
        super(shape, true, true);
        shape.setFill(Color.ORANGE);
    }
}
