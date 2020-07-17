package ir.ac.kntu.cs2d.map.item;

import ir.ac.kntu.cs2d.map.Item;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Gray extends Item {
    public Gray(Rectangle shape) {
        super(shape, true, false);
        shape.setFill(Color.GRAY);
    }
}
