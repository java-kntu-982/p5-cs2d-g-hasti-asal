package ir.ac.kntu.cs2d.map.item;

import ir.ac.kntu.cs2d.map.Item;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cream extends Item {
    public Cream(Rectangle shape) {
        super(shape, false, true);
        shape.setFill(Color.rgb(214,213, 162));
    }
}
