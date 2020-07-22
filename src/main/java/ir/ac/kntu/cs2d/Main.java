package ir.ac.kntu.cs2d;

import ir.ac.kntu.cs2d.gun.Gun;
import ir.ac.kntu.cs2d.gun.colt.Glock;
import ir.ac.kntu.cs2d.map.Map;
import ir.ac.kntu.cs2d.player.CounterTerrorist;
import ir.ac.kntu.cs2d.player.Player;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        int height = 700, width = 800;
        Scene scene = new Scene(root, width, height);
        stage.setScene(scene);
        stage.show();

        Game game = new Game(new Map(width, height));
        CounterTerrorist player = new CounterTerrorist(40, 100);
//        Thread thread = new Thread(player);
//        thread.start();
        player.setCurGun(new Glock(player));
        player.getCurGun().getBullets().forEach(bullet -> game.getBullets().add(bullet));
        game.getCt().add(player);

        game.getCt().forEach(ct -> ct.move(scene, game.getMap()));
        game.getCt().forEach(ct -> ct.shoot(scene));

        game.getCt().forEach(ct -> root.getChildren().add(ct.getShape()));
        game.getCt().forEach(ct -> root.getChildren().add(ct.getCurGun().getShape()));
        game.getCt().forEach(ct -> ct.getCurGun().getBullets().forEach(bullet -> root.getChildren().add(bullet.getShape())));
        game.getT().forEach(t -> root.getChildren().add(t.getShape()));
        game.getGuns().forEach(gun -> root.getChildren().add(gun.getShape()));
        game.getMap().getCreamWalls().forEach(cream -> root.getChildren().add(cream.getShape()));
        game.getMap().getOrangeWalls().forEach(orange -> root.getChildren().add(orange.getShape()));
        game.getMap().getBrownBoxes().forEach(brown -> root.getChildren().add(brown.getShape()));
        game.getMap().getGrayBoxes().forEach(gray -> root.getChildren().add(gray.getShape()));

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                game.getCt().forEach(Player::setXY);
                game.getT().forEach(Player::setXY);
                game.getGuns().forEach(Gun::setXY);
                game.getCt().forEach(counterTerrorist -> counterTerrorist.getCurGun().getBullets().forEach(bullet -> {
                    bullet.move(game.getMap(), game.getCt(), game.getT());
                    if (!bullet.isHit() && bullet.isShot() && bullet.didHit(game.getMap(), game.getCt(), game.getT())) {
//                        bullet.setHit(true);
                    } else if (!bullet.isShot() || bullet.isHit()) {
                        bullet.setXY();
                    }
                }));
                game.getT().forEach(terrorist -> terrorist.getCurGun().getBullets().forEach(bullet -> {
                    bullet.move(game.getMap(), game.getCt(), game.getT());
                    if (!bullet.isHit() && bullet.isShot() && bullet.didHit(game.getMap(), game.getCt(), game.getT())) {
                        bullet.setHit(true);
                    } else if (!bullet.isShot() || bullet.isHit()) {
                        bullet.setXY();
                    }
                }));
            }
        };
        animationTimer.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
