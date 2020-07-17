package ir.ac.kntu.cs2d;

import ir.ac.kntu.cs2d.map.Map;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main extends Application {
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



    }
}


//        List<Rectangle> rectangles = new ArrayList<>();
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
