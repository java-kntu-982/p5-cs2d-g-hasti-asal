package ir.ac.kntu.cs2d;

import ir.ac.kntu.cs2d.gun.Gun;
import ir.ac.kntu.cs2d.gun.main.*;
import ir.ac.kntu.cs2d.map.Map;
import ir.ac.kntu.cs2d.player.CounterTerrorist;
import ir.ac.kntu.cs2d.player.Player;
import ir.ac.kntu.cs2d.player.Terrorist;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.ParallelCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main extends Application {
    private int height = 700, width = 800;
    private Game game;
    private Player player;
    //private static final ArrayList<Player> players = new ArrayList<>();

    private GridPane startMenuPane;
    private GridPane terroristGunMenuPane;
    private GridPane antiTerroristGunMenuPane;
    private Group gamePane;

    private Scene startMenuScene;
    private Scene terroristGunMenuScene;
    private Scene antiTerroristGunMenuScene;
    private Scene gameScene;

    private boolean started = false;

    private Media music = new Media(new File("src/main/resources/sounds/522110__setuniman__cheeky-1t41b.wav").toURI().toString());
    private MediaPlayer mediaPlayer = new MediaPlayer(music);

    @Override
    public void start(Stage stage) {
        initialSetting(stage);
        stage.setTitle("cs");
        stage.show();
    }

    private void initialSetting(Stage stage) {
        game = new Game(new Map(width, height));
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
        try {
            startMenu(stage);
            terroristGunMenu(stage);
            antiTerroristGunMenu(stage);
//            game(stage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        stage.setScene(startMenuScene);
    }

    private void terroristGunMenu(Stage stage) throws FileNotFoundException {
        terroristGunMenuPane = new GridPane();
        Image gunImage = new Image(new FileInputStream("src/main/resources/images/gun2.jpg"));
        Image ak47Image = new Image(new FileInputStream("src/main/resources/images/ak47.png"));
        Image galilImage = new Image(new FileInputStream("src/main/resources/images/Galil.png"));
        Image p90Image = new Image(new FileInputStream("src/main/resources/images/p90.png"));
        Image mp5Image = new Image(new FileInputStream("src/main/resources/images/mp5.png"));
        ImageView imageView1 = new ImageView(ak47Image);
        imageView1.setFitHeight(45);
        imageView1.setFitWidth(50);
        terroristGunMenuPane.add(imageView1,1,0);
        ImageView imageView2 = new ImageView(galilImage);
        imageView2.setFitHeight(45);
        imageView2.setFitWidth(50);
        terroristGunMenuPane.add(imageView2,1,1);
        ImageView imageView3 = new ImageView(mp5Image);
        imageView3.setFitHeight(45);
        imageView3.setFitWidth(50);
        terroristGunMenuPane.add(imageView3,1,2);
        ImageView imageView4 = new ImageView(p90Image);
        imageView4.setFitHeight(45);
        imageView4.setFitWidth(50);
        terroristGunMenuPane.add(imageView4,1,3);

        Button ak47 = new Button("ak47");
        ak47.setStyle("-fx-pref-width: 200px;");
        ak47.setOnAction(e -> {
            player.setCurGun(new AK47(player));
            game.getGuns().add(player.getCurGun());
            game.setGuns(game.getGuns());
            game(stage);
            stage.setScene(gameScene);
        });
        terroristGunMenuPane.add(ak47, 0, 0);
        Button galil = new Button("Galil");
        galil.setStyle("-fx-pref-width: 200px;");
        galil.setOnAction(e -> {
            player.setCurGun(new Galil(player));
            game.getGuns().add(player.getCurGun());
            game.setGuns(game.getGuns());
            game(stage);
            stage.setScene(gameScene);
        });
        terroristGunMenuPane.add(galil, 0, 1);
        Button mp5 = new Button("MP5");
        mp5.setStyle("-fx-pref-width: 200px;");
        mp5.setOnAction(e -> {
            player.setCurGun(new MP5(player));
            game.getGuns().add(player.getCurGun());
            game.setGuns(game.getGuns());
            game(stage);
            stage.setScene(gameScene);
        });
        terroristGunMenuPane.add(mp5, 0, 2);
        Button p90 = new Button("P90");
        p90.setStyle("-fx-pref-width: 200px;");
        p90.setOnAction(e -> {
            player.setCurGun(new P90(player));
            game.getGuns().add(player.getCurGun());
            game.setGuns(game.getGuns());
            game(stage);
            stage.setScene(gameScene);
        });
        terroristGunMenuPane.add(p90, 0, 3);
        Button back = new Button("Back");
        back.setStyle("-fx-pref-width: 200px;");
        back.setOnAction(e -> {
            stage.setScene(startMenuScene);
        });
        terroristGunMenuPane.add(back,0,4);
        terroristGunMenuPane.setBackground(new Background(new BackgroundImage(gunImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        terroristGunMenuScene = new Scene(terroristGunMenuPane, width, height);
        terroristGunMenuPane.setPadding(new Insets(30, 30, 30, 30));
        terroristGunMenuPane.setVgap(10);
        terroristGunMenuPane.setHgap(10);

    }
    private void antiTerroristGunMenu(Stage stage) throws FileNotFoundException {
        antiTerroristGunMenuPane = new GridPane();
        Image gunImage = new Image(new FileInputStream("src/main/resources/images/gun2.jpg"));
        Button m4A1 = new Button("M4A1");
        m4A1.setStyle("-fx-pref-width: 200px;");
        Image m4A1image = new Image(new FileInputStream("src/main/resources/images/M4A1.png"));
        Image famasImage = new Image(new FileInputStream("src/main/resources/images/famas.png"));
        Image mp5Image = new Image(new FileInputStream("src/main/resources/images/mp5.png"));
        Image p90Image = new Image(new FileInputStream("src/main/resources/images/p90.png"));
        ImageView imageView1 = new ImageView(m4A1image);
        imageView1.setFitHeight(45);
        imageView1.setFitWidth(50);
        antiTerroristGunMenuPane.add(imageView1,1,0);
        ImageView imageView2 = new ImageView(famasImage);
        imageView2.setFitHeight(45);
        imageView2.setFitWidth(50);
        antiTerroristGunMenuPane.add(imageView2,1,1);
        ImageView imageView3 = new ImageView(mp5Image);
        imageView3.setFitHeight(45);
        imageView3.setFitWidth(50);
        antiTerroristGunMenuPane.add(imageView3,1,2);
        ImageView imageView4 = new ImageView(p90Image);
        imageView4.setFitHeight(45);
        imageView4.setFitWidth(50);
        antiTerroristGunMenuPane.add(imageView4,1,3);
        m4A1.setOnAction(e -> {
            player.setCurGun(new M4A1(player));
            game.getGuns().add(player.getCurGun());
            game.setGuns(game.getGuns());
            game(stage);
            stage.setScene(gameScene);
        });
        antiTerroristGunMenuPane.add(m4A1, 0, 0);
        Button famas = new Button("Famas");
        famas.setStyle("-fx-pref-width: 200px;");
        famas.setOnAction(e -> {
            player.setCurGun(new Famas(player));
            game.getGuns().add(player.getCurGun());
            game.setGuns(game.getGuns());
            game(stage);
            stage.setScene(gameScene);
        });
        antiTerroristGunMenuPane.add(famas, 0, 1);
        Button mp5 = new Button("MP5");
        mp5.setStyle("-fx-pref-width: 200px;");
        mp5.setOnAction(e -> {
            player.setCurGun(new MP5(player));
            game.getGuns().add(player.getCurGun());
            game.setGuns(game.getGuns());
            game(stage);
            stage.setScene(gameScene);
        });
        antiTerroristGunMenuPane.add(mp5, 0, 2);
        Button p90 = new Button("P90");
        p90.setStyle("-fx-pref-width: 200px;");
        p90.setOnAction(e -> {
            player.setCurGun(new P90(player));
            game.getGuns().add(player.getCurGun());
            game.setGuns(game.getGuns());
            game(stage);
            stage.setScene(gameScene);
        });
        antiTerroristGunMenuPane.add(p90, 0, 3);
        Button back = new Button("Back");
        back.setStyle("-fx-pref-width: 200px;");
        back.setOnAction(e -> {
            stage.setScene(startMenuScene);
        });
        antiTerroristGunMenuPane.add(back,0,4);
        antiTerroristGunMenuPane.setBackground(new Background(new BackgroundImage(gunImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        antiTerroristGunMenuScene = new Scene(antiTerroristGunMenuPane, width, height);
        antiTerroristGunMenuPane.setPadding(new Insets(30, 30, 30, 30));
        antiTerroristGunMenuPane.setVgap(10);
        antiTerroristGunMenuPane.setHgap(10);



    }

    private void startMenu(Stage stage) throws FileNotFoundException {
        Image startImage = new Image(new FileInputStream("src/main/resources/images/startmenu.jpg"));
        startMenuPane = new GridPane();
        startMenuPane.setBackground(new Background(new BackgroundImage(startImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        startMenuScene = new Scene(startMenuPane, width, height);
        startMenuPane.setPadding(new Insets(450, 250, 250, 250));
        startMenuPane.setVgap(10);
        startMenuPane.setHgap(10);

        Button ct = new Button("Counter terrorist");
        ct.setStyle("-fx-pref-width: 200px;");
        ct.setOnAction(e -> {
            player = new CounterTerrorist(40, 150);
            game.getCt().add((CounterTerrorist) player);
            stage.setScene(antiTerroristGunMenuScene);
        });
        startMenuPane.add(ct, 0, 0);

        Button t = new Button("Terrorist");
        t.setStyle("-fx-pref-width: 200px;");
        t.setOnAction(e -> {
            player = new Terrorist(750, 200);
            game.getT().add((Terrorist) player);
            stage.setScene(terroristGunMenuScene);
        });
        Button exit = new Button("Exit");
        exit.setOnAction(e ->{
            stage.close();
        } );
        exit.setStyle("-fx-pref-width: 200px;");
        startMenuPane.add(t, 1, 0);
        startMenuPane.add(exit,1,1);
    }
    private void game(Stage stage){
        gamePane =  new Group();
        gameScene = new Scene(gamePane, width, height);
        ParallelCamera camera = new ParallelCamera();
        camera.setScaleX(0.5);
        camera.setScaleY(0.5);
        gameScene.setCamera(camera);

        game.getCt().forEach(ct -> ct.move(gameScene, game.getMap()));
        game.getCt().forEach(ct -> ct.shoot(gameScene));
        game.getT().forEach(t -> t.move(gameScene, game.getMap()));
        game.getT().forEach(t -> t.shoot(gameScene));


        game.getCt().forEach(ct -> gamePane.getChildren().add(ct.getShape()));
        game.getCt().forEach(ct -> gamePane.getChildren().add(ct.getCurGun().getShape()));
        game.getCt().forEach(ct -> ct.getCurGun().getBullets().forEach(bullet -> gamePane.getChildren().add(bullet.getShape())));
        game.getT().forEach(t -> gamePane.getChildren().add(t.getShape()));
        game.getT().forEach(t -> gamePane.getChildren().add(t.getCurGun().getShape()));
        game.getT().forEach(t -> t.getCurGun().getBullets().forEach(bullet -> gamePane.getChildren().add(bullet.getShape())));
//        game.getGuns().forEach(gun -> gamePane.getChildren().add(gun.getShape()));
        game.getMap().getCreamWalls().forEach(cream -> gamePane.getChildren().add(cream.getShape()));
        game.getMap().getOrangeWalls().forEach(orange -> gamePane.getChildren().add(orange.getShape()));
        game.getMap().getBrownBoxes().forEach(brown -> gamePane.getChildren().add(brown.getShape()));
        game.getMap().getGrayBoxes().forEach(gray -> gamePane.getChildren().add(gray.getShape()));

        new AnimationTimer() {
            @Override
            public void handle(long l) {
                game.getCt().forEach(Player::setXY);
                game.getT().forEach(Player::setXY);
                game.getGuns().forEach(Gun::setXY);
                game.getCt().forEach(counterTerrorist -> {
                    if (counterTerrorist.getCurGun() != null) {
                        counterTerrorist.getCurGun().getBullets().forEach(bullet -> {
                            bullet.move(game.getMap(), game.getCt(), game.getT());
                        });
                    }
                });
                game.getT().forEach(terrorist -> {
                    if (terrorist.getCurGun() != null) {
                        terrorist.getCurGun().getBullets().forEach(bullet -> {
                            bullet.move(game.getMap(), game.getCt(), game.getT());
                        });
                    }
                });
                if (player != null) {
                    camera.setLayoutX(player.getX() - width / 4);
                    camera.setLayoutY(player.getY() - height / 4);
                }
            }
        }.start();
    }


    public static void main(String[] args) {
        launch(args);
    }
}