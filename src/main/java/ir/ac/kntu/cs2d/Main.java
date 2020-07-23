package ir.ac.kntu.cs2d;

import ir.ac.kntu.cs2d.gun.Gun;
import ir.ac.kntu.cs2d.gun.main.*;
import ir.ac.kntu.cs2d.map.Map;
import ir.ac.kntu.cs2d.player.CounterTerrorist;
import ir.ac.kntu.cs2d.player.Player;
import ir.ac.kntu.cs2d.player.Terrorist;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    private int height = 700, width = 800;
    private Game game;
    //private static final ArrayList<Player> players = new ArrayList<>();

    private GridPane startMenuPane;
    private GridPane terroristGunMenuPane;
    private GridPane Anti_TerroristGunMenuPane;
    private GridPane gamePane;

    private Scene startMenuScene;
    private Scene terroristGunMenuScene;
    private Scene Anti_TerroristGunMenuScene;
    private Scene gameScene;

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
            Anti_TerroristGunMenu(stage);
            //game(stage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        stage.setScene(startMenuScene);
    }

    private void terroristGunMenu(Stage stage) throws FileNotFoundException {
        terroristGunMenuPane = new GridPane();
        Image gunImage = new Image(new FileInputStream("src/main/resources/images/gun2.jpg"));
        Image AK47image = new Image(new FileInputStream("src/main/resources/images/AK47.png"));
        Image galilImage = new Image(new FileInputStream("src/main/resources/images/Galil.png"));
        Image MP5Image = new Image(new FileInputStream("src/main/resources/images/mp5.png"));
        Image P90Image = new Image(new FileInputStream("src/main/resources/images/p90.png"));
        ImageView imageView1 = new ImageView(AK47image);
        imageView1.setFitHeight(45);
        imageView1.setFitWidth(50);
        terroristGunMenuPane.add(imageView1,1,0);
        ImageView imageView2 = new ImageView(galilImage);
        imageView2.setFitHeight(45);
        imageView2.setFitWidth(50);
        terroristGunMenuPane.add(imageView2,1,1);
        ImageView imageView3 = new ImageView(MP5Image);
        imageView3.setFitHeight(45);
        imageView3.setFitWidth(50);
        terroristGunMenuPane.add(imageView3,1,2);
        ImageView imageView4 = new ImageView(P90Image);
        imageView4.setFitHeight(45);
        imageView4.setFitWidth(50);
        terroristGunMenuPane.add(imageView4,1,3);

        Button AK47 = new Button("AK47");
        AK47.setStyle("-fx-pref-width: 200px;");
        AK47.setOnAction(e -> {
            game.getGuns().add(new AK47(game.getT().get(0)));
            game.setGuns(game.getGuns());
            stage.setScene(gameScene);
        });
        terroristGunMenuPane.add(AK47, 0, 0);
        Button galil = new Button("Galil");
        galil.setStyle("-fx-pref-width: 200px;");
        galil.setOnAction(e -> {
            game.getGuns().add(new Galil(game.getT().get(0)));
            game.setGuns(game.getGuns());
            stage.setScene(gameScene);
        });
        terroristGunMenuPane.add(galil, 0, 1);
        Button MP5 = new Button("MP5");
        MP5.setStyle("-fx-pref-width: 200px;");
        MP5.setOnAction(e -> {
            game.getGuns().add(new MP5(game.getT().get(0)));
            game.setGuns(game.getGuns());
            stage.setScene(gameScene);
        });
        terroristGunMenuPane.add(MP5, 0, 2);
        Button P90 = new Button("P90");
        P90.setStyle("-fx-pref-width: 200px;");
        P90.setOnAction(e -> {
            game.getGuns().add(new P90(game.getT().get(0)));
            game.setGuns(game.getGuns());
            stage.setScene(gameScene);
        });
        terroristGunMenuPane.add(P90, 0, 3);
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
    private void Anti_TerroristGunMenu(Stage stage) throws FileNotFoundException {
        Anti_TerroristGunMenuPane = new GridPane();
        Image gunImage = new Image(new FileInputStream("src/main/resources/images/gun2.jpg"));
        Button M4A1 = new Button("M4A1");
        M4A1.setStyle("-fx-pref-width: 200px;");
        Image M4A1image = new Image(new FileInputStream("src/main/resources/images/M4A1.png"));
        Image famasImage = new Image(new FileInputStream("src/main/resources/images/famas.png"));
        Image MP5Image = new Image(new FileInputStream("src/main/resources/images/mp5.png"));
        Image P90Image = new Image(new FileInputStream("src/main/resources/images/p90.png"));
        ImageView imageView1 = new ImageView(M4A1image);
        imageView1.setFitHeight(45);
        imageView1.setFitWidth(50);
        Anti_TerroristGunMenuPane.add(imageView1,1,0);
        ImageView imageView2 = new ImageView(famasImage);
        imageView2.setFitHeight(45);
        imageView2.setFitWidth(50);
        Anti_TerroristGunMenuPane.add(imageView2,1,1);
        ImageView imageView3 = new ImageView(MP5Image);
        imageView3.setFitHeight(45);
        imageView3.setFitWidth(50);
        Anti_TerroristGunMenuPane.add(imageView3,1,2);
        ImageView imageView4 = new ImageView(P90Image);
        imageView4.setFitHeight(45);
        imageView4.setFitWidth(50);
        Anti_TerroristGunMenuPane.add(imageView4,1,3);
        M4A1.setOnAction(e -> {
            game.getGuns().add(new M4A1(game.getT().get(0)));
            game.setGuns(game.getGuns());
            stage.setScene(gameScene);
        });
        Anti_TerroristGunMenuPane.add(M4A1, 0, 0);
        Button famas = new Button("Famas");
        famas.setStyle("-fx-pref-width: 200px;");
        famas.setOnAction(e -> {
            game.getGuns().add(new Famas(game.getT().get(0)));
            game.setGuns(game.getGuns());
            stage.setScene(gameScene);
        });
        Anti_TerroristGunMenuPane.add(famas, 0, 1);
        Button MP5 = new Button("MP5");
        MP5.setStyle("-fx-pref-width: 200px;");
        MP5.setOnAction(e -> {
            game.getGuns().add(new MP5(game.getT().get(0)));
            game.setGuns(game.getGuns());
            stage.setScene(gameScene);
        });
        Anti_TerroristGunMenuPane.add(MP5, 0, 2);
        Button P90 = new Button("P90");
        P90.setStyle("-fx-pref-width: 200px;");
        P90.setOnAction(e -> {
            game.getGuns().add(new P90(game.getT().get(0)));
            game.setGuns(game.getGuns());
            stage.setScene(gameScene);
        });
        Anti_TerroristGunMenuPane.add(P90, 0, 3);
        Button back = new Button("Back");
        back.setStyle("-fx-pref-width: 200px;");
        back.setOnAction(e -> {
            stage.setScene(startMenuScene);
        });
        Anti_TerroristGunMenuPane.add(back,0,4);
        Anti_TerroristGunMenuPane.setBackground(new Background(new BackgroundImage(gunImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        Anti_TerroristGunMenuScene = new Scene(Anti_TerroristGunMenuPane, width, height);
        Anti_TerroristGunMenuPane.setPadding(new Insets(30, 30, 30, 30));
        Anti_TerroristGunMenuPane.setVgap(10);
        Anti_TerroristGunMenuPane.setHgap(10);



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
            game.getCt().add(new CounterTerrorist(80, 150));
            stage.setScene(Anti_TerroristGunMenuScene);
        });
        startMenuPane.add(ct, 0, 0);

        Button t = new Button("Terrorist");
        t.setStyle("-fx-pref-width: 200px;");
        t.setOnAction(e -> {
            game.getT().add(new Terrorist(750, 200));

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
        gamePane =  new GridPane();
        gameScene = new Scene(gamePane, width, height);
        gamePane.setPadding(new Insets(450, 250, 250, 250));
        gamePane.setVgap(10);
        gamePane.setHgap(10);
        Button back = new Button("Back");
        back.setStyle("-fx-pref-width: 200px;");
        back.setOnAction(e -> {
            stage.setScene(startMenuScene);
        });
        gamePane.add(back,0,2);
        gameScene = new Scene(gamePane, 960, 600);
        stage.setScene(gameScene);
    }


    public static void main(String[] args) {
        launch(args);
    }
}