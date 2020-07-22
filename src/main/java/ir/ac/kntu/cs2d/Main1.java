package ir.ac.kntu.cs2d;

import ir.ac.kntu.cs2d.gun.colt.Glock;
import ir.ac.kntu.cs2d.map.Map;
import ir.ac.kntu.cs2d.map.item.Brown;
import ir.ac.kntu.cs2d.map.item.Cream;
import ir.ac.kntu.cs2d.map.item.Gray;
import ir.ac.kntu.cs2d.map.item.Orange;
import ir.ac.kntu.cs2d.player.CounterTerrorist;
import ir.ac.kntu.cs2d.player.Player;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main1 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        int height = 700, width = 800;
        Scene scene = new Scene(root, width, height);
        stage.setScene(scene);
        stage.show();

        Map map = new Map(width, height);
        map.getCreamWalls().forEach(cream -> root.getChildren().add(cream.getShape()));
//        map.getGrayBoxes().forEach(gray -> root.getChildren().add(gray.getShape()));
//        map.getOrangeWalls().forEach(orange -> root.getChildren().add(orange.getShape()));
//        map.getBrownBoxes().forEach(brown -> root.getChildren().add(brown.getShape()));


//        List<Rectangle> bombSite = new ArrayList<>();
//
//        bombSite.add(new Rectangle(height/25, height/3 - height/12 - height/14 - height/16, width/8 + height/100, height/14 - height/100)); //a
//        bombSite.add(new Rectangle(height/25, height/25. + height/2.5 + height/5. + height/15, width/10, height/9)); //b
//
//        bombSite.forEach(rectangle -> rectangle.setFill(Color.RED));
//        bombSite.forEach(rectangle -> root.getChildren().add(rectangle));

//        List<Rectangle> rectangles1 = new ArrayList<>();
//        rectangles1.add(new Rectangle(width/4.5, height/120, height/25 - height/120, height/25 - height/120));// bala
//        rectangles1.add(new Rectangle(width/8, height/3 - height/12 - height/14 - height/16, height/55, height/55));// samt a
//        rectangles1.add(new Rectangle(width/9, height/3 - height/12 - height/14 - height/55, width/50, height/55));
//        rectangles1.add(new Rectangle(height/25 + width/16 - height/55, height/3 - height/12 - height/14, height/55, height/55)); //gray
//        rectangles1.add(new Rectangle(height/25, height/3 - height/12 - height/50, height/55, height/35));
//        rectangles1.add(new Rectangle(height/25 + width/16 + height/100, height/3 - height/12 - height/55, height/55, height/55));
//        rectangles1.add(new Rectangle(width - width/50 - width/3.5 - width/6 - width/30 - width/25 + width/80, height/10 - height/15 + height/120, height/75, height/75)); // vasat bala
//        rectangles1.add(new Rectangle(width/6 + width/8 + width/11, height/9.5, height/60, height/75));
//        rectangles1.add(new Rectangle(width - width/50 - width/3.5 - width/6 - width/30, height/10, height/60, height/75));
//        rectangles1.add(new Rectangle(width/6 + width/8 + width/11.5 - width/18 - width/40 - width/120, height/3 - height/12 + height/9 - height/100, height/40, height/40));// samt ct
//        rectangles1.add(new Rectangle(width/6 + width/8 + width/11.5 + width/20, height/3 - height/12 + height/9, height/30, height/30));
//        rectangles1.add(new Rectangle(width/6 + width/8 + width/11.5 - width/18 - height/35, height/3 - height/12 + height/9 - height/50 + height/15, height/35, height/50));
//        rectangles1.add(new Rectangle(width/2 + width/25, height/25 + height/2.5 - height/50, height/40, height/50));
//        rectangles1.add(new Rectangle(width/2 + width/25 + width/50 + width/8, height/25 + height/2.5 - height/40, height/40, height/40)); //samt ct
//        rectangles1.add(new Rectangle(width/2 + width/25 + width/50 + width/5, height/25 + height/2.5 + height/100 + width/55, height/40, height/40));
//        rectangles1.add(new Rectangle(width/4. + width/4. + width/25. + width/50. + width/20. + width/16. - width/30, height/25. + height/2.5 + height/100. + width/55. + height/18, width/30, height/15));
//        rectangles1.add(new Rectangle(width - width/50 - width/30, height/4, width/30, height/15)); //chasbide be divar rast
//        rectangles1.add(new Rectangle(width - width/4, height - height/6, width/10, height/15)); // paen rast
//        rectangles1.add(new Rectangle(width/6. + width/8. + width/11.5 - width/18. - width/100. + width/16.5, height/3. - height/12. + height/9. - height/100. + height/15. + height/4.5, width/50, height/50)); // gray vasat
//        rectangles1.add(new Rectangle(width/6. + width/8. + width/11.5 - width/18. - width/100. + width/8, height/3. - height/12. + height/9. - height/100. + height/15. + height/3.5, width/50, height/50)); // vasat
//        rectangles1.add(new Rectangle(width/6. + width/8. + width/11.5 - width/18. - width/100. + width/18, height/3. - height/12. + height/9. - height/100. + height/15. + height/2.75, width/50, height/50));
//        rectangles1.add(new Rectangle(width/2.5, height/25. + height/2.5 + height/5. + height/15. + height/4. - height/30. - height/50, width/50, height/50));
//        rectangles1.add(new Rectangle(height/25, height - height/4.5, width/50, height/50)); //samt b
//        rectangles1.add(new Rectangle(height/10, height - height/3.75, width/50, height/50));
//        rectangles1.add(new Rectangle(width/6, height - height/6 - height/50, width/50, height/50));
//        rectangles1.add(new Rectangle(width/15, height - height/6 + height/120, width/50, height/50));
//        rectangles1.add(new Rectangle(width/7, height - height/6 + height/120, width/50, height/50));
//        rectangles1.add(new Rectangle(width/7 - width/35, height/25. + height/2.5 + height/5. + height/15. + height/4. - height/50, width/40, height/50));
//        rectangles1.add(new Rectangle(width/15, height/25. + height/2.5 + height/5. + height/15. + height/4. - height/50, width/50, height/50));
//        rectangles1.add(new Rectangle(width/7.5, height/25. + height/2.5 + height/5. + height/15., width/50, height/60)); //gray
//        rectangles1.add(new Rectangle(width/4, height - height/4, width/50, height/50));
//        rectangles1.add(new Rectangle(width/6. + width/8. + width/11.5 - width/18. - width/100. - width/20, height - height/2.5, width/20, height/50));
//
//        rectangles1.forEach(rectangle -> rectangle.setFill(Color.BROWN));
//        rectangles1.forEach(rectangle -> root.getChildren().add(rectangle));
//
//        List<Rectangle> rectangles2 = new ArrayList<>();
//        rectangles2.add(new Rectangle(height/25 + width/16, height/3 - height/12, width/16, height/100)); // samt a
//        rectangles2.add(new Rectangle(height/25 + width/16, height/3 - height/12 - height/14, height/100, height/14));
//        rectangles2.add(new Rectangle(height/25 + width/16, height/3 - height/12 - height/14, width/16 + height/100, height/100));
//        rectangles2.add(new Rectangle(height/25 + width/8 + height/100, height/3 - height/12 - height/14 - height/16, height/100, height/16 + height/100));
//        rectangles2.add(new Rectangle(height/25 + width/8 + height/100 - width/16, height/3 - height/12 - height/14 - height/16 - height/100, width/16 + height/100, height/100));
//        rectangles2.add(new Rectangle(width - width/50 - width/3.5 - width/6 - width/30 - width/20, height/10 - height/50, width/20, height/120)); // vasat bala
//        rectangles2.add(new Rectangle(width - width/50 - width/3.5 - width/6 - width/30 - width/25, height/10 - height/15, width/25, height/120));
//        rectangles2.add(new Rectangle(width/6 + width/8 + width/11.5, height/3 - height/12 + height/9 - height/100, width/9, height/100));// samt ct
//        rectangles2.add(new Rectangle(width/4. + width/4. + width/25. + width/50. + width/20. + width/5., height/25. + height/2.5 - height/8. + height/100. + width/55. - height/8, width/50, height/8));// samt t
//        rectangles2.add(new Rectangle(width/4. + width/4. + width/25. + width/50. + width/20. + width/16 + width/10, height/25. + height/2.5 + height/100. + width/55. + height/4., width/10, height/30));
//        rectangles2.add(new Rectangle(width/6. + width/8. + width/11.5 - width/18. - width/100. + width/16.5, height/3. - height/12. + height/9. - height/100. + height/15. + height/8., width/20, height/40)); // vasat
//        rectangles2.add(new Rectangle(width/6. + width/8. + width/11.5 - width/18. - width/100. + width/16.5 + width/20, height/3. - height/12. + height/9. - height/100. + height/15. + height/8., width/40, height/15));
//        rectangles2.add(new Rectangle(height/25, height - height/6, width/5, height/120));// samt b
//        rectangles2.add(new Rectangle(width/9.5, height/25. + height/2.5 + height/5. + height/15 - height/120, width/7.5 - width/9.5, height/120));
//
//
//
//        rectangles2.forEach(rectangle -> rectangle.setFill(Color.ORANGE));
//        rectangles2.forEach(rectangle -> root.getChildren().add(rectangle));


//        List<Rectangle> spawn = new ArrayList<>();
//
//        spawn.add(new Rectangle(height/25. + width/8. + width/50., height/3. - height/12., width/4. + width/50. - width/8.,  height/12. + height/50.)); //ct
//        spawn.add(new Rectangle(width/4. + width/4. + width/25. + width/50. + width/20. + width/5. + width/50, height/4 + height/15, width - width/25 - (width/4. + width/4. + width/25. + width/50. + width/20. + width/5.), height/8)); //t
//
//        spawn.forEach(rectangle -> root.getChildren().add(rectangle));

//        Circle player = new Circle(40, 100, 5, Color.PURPLE);
//        scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent keyEvent) {
//                if (keyEvent.getCode() == KeyCode.W && canGoUpOrDown(map, player, -1)) {
//                    player.setCenterY(player.getCenterY() - 1);
//                } else if (keyEvent.getCode() == KeyCode.S && canGoUpOrDown(map, player, 1)) {
//                    player.setCenterY(player.getCenterY() + 1);
//                } else if (keyEvent.getCode() == KeyCode.A && canGoLeftOrRight(map, player, -1)) {
//                    player.setCenterX(player.getCenterX() - 1);
//                } else if (keyEvent.getCode() == KeyCode.D && canGoLeftOrRight(map, player, 1)) {
//                    player.setCenterX(player.getCenterX() + 1);
//                }
//            }
//        });
//
//        Line gun = new Line(40, 100, 50, 100);
//
//        root.getChildren().add(player);
//        root.getChildren().add(gun);

        CounterTerrorist ct = new CounterTerrorist(40, 100);
        ct.setCurGun(new Glock(ct));
        ct.move(scene, map);
        root.getChildren().add(ct.getShape());
        root.getChildren().add(ct.getCurGun().getShape());



    }

    public static boolean canGoUpOrDown(Map map, Circle player, int a) {
        player.setCenterY(player.getCenterY() + a);
        for (Cream r1: map.getCreamWalls()) {
            if (r1.getShape().getBoundsInParent().intersects(player.getBoundsInParent())) {
                player.setCenterY(player.getCenterY() - a);
                return false;
            }
        }
        for (Brown r1: map.getBrownBoxes()) {
            if (r1.getShape().getBoundsInParent().intersects(player.getBoundsInParent())) {
                player.setCenterY(player.getCenterY() - a);
                return false;
            }
        }
        for (Gray r1: map.getGrayBoxes()) {
            if (r1.getShape().getBoundsInParent().intersects(player.getBoundsInParent())) {
                player.setCenterY(player.getCenterY() - a);
                return false;
            }
        }
        for (Orange r1: map.getOrangeWalls()) {
            if (r1.getShape().getBoundsInParent().intersects(player.getBoundsInParent())) {
                player.setCenterY(player.getCenterY() - a);
                return false;
            }
        }
        player.setCenterY(player.getCenterY() - a);
        return true;
    }

    public static boolean canGoLeftOrRight(Map map, Circle player, int a) {
        player.setCenterX(player.getCenterX() + a);
        for (Cream r1: map.getCreamWalls()) {
            if (r1.getShape().getBoundsInParent().intersects(player.getBoundsInParent())) {
                player.setCenterX(player.getCenterX() - a);
                return false;
            }
        }
        for (Brown r1: map.getBrownBoxes()) {
            if (r1.getShape().getBoundsInParent().intersects(player.getBoundsInParent())) {
                player.setCenterX(player.getCenterX() - a);
                return false;
            }
        }
        for (Gray r1: map.getGrayBoxes()) {
            if (r1.getShape().getBoundsInParent().intersects(player.getBoundsInParent())) {
                player.setCenterX(player.getCenterX() - a);
                return false;
            }
        }
        for (Orange r1: map.getOrangeWalls()) {
            if (r1.getShape().getBoundsInParent().intersects(player.getBoundsInParent())) {
                player.setCenterX(player.getCenterX() - a);
                return false;
            }
        }
        player.setCenterX(player.getCenterX() - a);
        return true;
    }
}


//        rectangles.add(new Rectangle(0, 0, width/6., height/25.));
//        rectangles.add(new Rectangle(0, height/25., height/25., height/2.5));
//        rectangles.add(new Rectangle(0, height/25. + height/2.5, width/7.5, height/5.));
//        rectangles.add(new Rectangle(0, height/25. + height/2.5 + height/5., width/9.5, height/15.));
//        rectangles.add(new Rectangle(0, height/25. + height/2.5 + height/5. + height/15., height/25., height/4.));
//        rectangles.add(new Rectangle(0, height/25. + height/2.5 + height/5. + height/15. + height/4., width, 287*height/300.));
//        rectangles.add(new Rectangle(height/25., height/3., width/8., height/50.));
//        rectangles.add(new Rectangle(height/25. + width/8., height/3. - height/12., height/50., height/12. + height/50.));
//        rectangles.add(new Rectangle(width/7.5, height/25. + height/2.5 + height/5. + height/15. - height/80., width/12., height/80.));
//        rectangles.add(new Rectangle(width/7., height/25. + height/2.5 + height/5. + height/15. + height/4. - height/60., height/60., height/60.));
//        rectangles.add(new Rectangle(width/4., height/25. + height/2.5 + height/5. + height/15. + height/4. - height/30., width/4.5, height/30.));
//        rectangles.add(new Rectangle(width/4. + width/4.5, height/25. + height/2.5 + height/5. + height/15. + height/4. - height/5., width/25., height/5.));
//        rectangles.add(new Rectangle(width - width/50., 0, width/50., height));
//        rectangles.add(new Rectangle(width - width/50. - width/3.5, 0, width/3.5, height/8.));
//        rectangles.add(new Rectangle(width - width/50. - width/3.5 - width/6., 0, width/6., height/12.));
//        rectangles.add(new Rectangle(width - width/50. - width/3.5 - width/6. - width/30., 0, width/30., height/10.));
//        rectangles.add(new Rectangle(width/6. + width/8., 0, width/9., height/25.));
//        rectangles.add(new Rectangle(width/6., 0, width/8., height/120.));
//        rectangles.add(new Rectangle(width/6. + width/8. + width/11., 0, width/8., height/120.));
//        rectangles.add(new Rectangle(width/6. + width/8., height/11., width/11., height/20.)); // vasatia bala
//        rectangles.add(new Rectangle(width/6. + width/8., height/11. + height/20., width/4., height/100.));
//        rectangles.add(new Rectangle(width/3. + width/8., height/11. + height/20. + height/100., width/23., height/10.));
//        rectangles.add(new Rectangle(width/6. + width/8., height/3. - height/12. - height/25., width/11.5, height/25.)); // samt ct
//        rectangles.add(new Rectangle(width/6. + width/8. + width/11.5 - width/18., height/3. - height/12., width/18., height/9.));
//        rectangles.add(new Rectangle(width/6. + width/8. + width/11.5 - width/18. - width/100., height/3. - height/12. + height/9. - height/100., width/100., height/100.));
//        rectangles.add(new Rectangle(width/6. + width/8. + width/11.5 - width/18. - width/100., height/3. - height/12. + height/9. - height/100. + height/15., width/100., height/10.)); // paine ct
//        rectangles.add(new Rectangle(width/6. + width/8. + width/11.5 - width/18. - width/100., height/3. - height/12. + height/9. - height/100. + height/15. + height/10., width/16.5, height/25. + height/2.5 + height/5. + height/15. - height/80. - (height/3. - height/12. + height/9. - height/100. + height/15. + height/10.)));
//        rectangles.add(new Rectangle(width/6. + width/8. + width/11.5 - width/18. - width/100. - width/50., height/25. + height/2.5 + height/5. + height/15. - height/80., width/50. + width/16.5, height/100.));
//        rectangles.add(new Rectangle(width/6. + width/8. + width/11.5 - width/18. - width/100. + width/60., height/25. + height/2.5 + height/5. + height/15. - height/80. + height/100., width/16.5 - width/60., height/90.));
//        rectangles.add(new Rectangle(width/6. + width/8. + width/11.5 - width/18. - width/100. + width/60. + width/80., height/25. + height/2.5 + height/5. + height/15. - height/80. + height/100. + height/90., width/16.5 - width/80.- width/60., height/90.));
//        rectangles.add(new Rectangle(width/6. + width/8. + width/11.5 - width/18. - width/100. + width/60. + width/80., height/25. + height/2.5 + height/5. + height/15. - height/80. + height/100. + height/90. + height/90., width/100., height/50.));
//        rectangles.add(new Rectangle(width/6. + width/8. + width/11.5 - width/18. - width/100. + width/60., height/25. + height/2.5 + height/5. + height/15. - height/80. + height/100. + height/90. + height/90. + height/50.,  width/80.+ width/100., height/50.));
//        rectangles.add(new Rectangle(width/6. + width/8. + width/11.5 - width/18. - width/100., height/25. + height/2.5 + height/5. + height/15. - height/80. + height/100. + height/90. + height/90. + height/50. + height/50.,  width/80. + width/60. + width/100., height/50.));
//        rectangles.add(new Rectangle(width/4. + width/4., height/25. + height/2.5, width/50., height/5.)); // samt t
//        rectangles.add(new Rectangle(width/4. + width/4. + width/50., height/25. + height/2.5, width/50., height/4.));
//        rectangles.add(new Rectangle(width/4. + width/4. - width/10., height/25. + height/2.5, width/10., height/20.));
//        rectangles.add(new Rectangle(width/4. + width/4. + width/25., height/25. + height/2.5 + width/55., width/50., height/7.));
//        rectangles.add(new Rectangle(width/4. + width/4. + width/25. + width/50., height/25. + height/2.5 + width/55., width/20., height/100.));
//        rectangles.add(new Rectangle(width/4. + width/4. + width/25. + width/50. + width/20., height/25. + height/2.5, width/5., height/100. + width/55.));
//        rectangles.add(new Rectangle(width/4. + width/4. + width/25. + width/50. + width/20. + width/5., height/25. + height/2.5 - height/8. + height/100. + width/55., width/50., height/8.));
//        rectangles.add(new Rectangle(width/4. + width/4. + width/25. + width/50. + width/20. + width/16., height/25. + height/2.5 + height/100. + width/55., width/25., height/4.));
//        rectangles.add(new Rectangle(width/4. + width/4. + width/25. + width/50. + width/20. + width/16., height/25. + height/2.5 + height/100. + width/55. + height/4., width/10., height/30.));
//        rectangles.add(new Rectangle(3*width/4.5, height/4., width/20., height/8.)); // mostatil vasat bala
//        rectangles.forEach(rectangle -> root.getChildren().add(rectangle));



//        Rectangle r1 = new Rectangle(0,0,300, 400);
//        Circle r2 = new Circle(350,500,100);
//        if (r1.getBoundsInParent().intersects(r2.getBoundsInParent())) {
//            System.out.println("yes");
//        } else {
//            System.out.println("no");
//        }
//        Shape shape = Shape.intersect(r1, r2);
//        shape.setFill(Color.ORANGE);
//        System.out.println();
//        x, y, width, height
