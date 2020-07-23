package ir.ac.kntu.cs2d;

import ir.ac.kntu.cs2d.map.Map;
import ir.ac.kntu.cs2d.player.CounterTerrorist;
import ir.ac.kntu.cs2d.player.Terrorist;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
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

    private GridPane startMenuPane;
    private GridPane gunMenuPane;

    private Scene startMenuScene;
    private Scene gunMenuScene;

    private Media music = new Media(new File("src/main/resources/sounds/522110__setuniman__cheeky-1t41b.wav").toURI().toString());
    private MediaPlayer mediaPlayer = new MediaPlayer(music);

    @Override
    public void start(Stage stage) {
        initialSetting(stage);
        stage.setTitle("sc");
        stage.show();
    }

    private void initialSetting(Stage stage) {
        game = new Game(new Map(width, height));
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
        try {
            startMenu(stage);
            gunMenu(stage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        stage.setScene(startMenuScene);
    }

    private void gunMenu(Stage stage) {
        gunMenuPane = new GridPane();
        gunMenuScene = new Scene(gunMenuPane, width, height);
        gunMenuPane.setPadding(new Insets(30, 30, 30, 30));
        gunMenuPane.setVgap(10);
        gunMenuPane.setHgap(10);


    }

    private void startMenu(Stage stage) throws FileNotFoundException {
        Image image = new Image(new FileInputStream("src/main/resources/images/startmenu.jpg"));
        startMenuPane = new GridPane();
        startMenuPane.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        startMenuScene = new Scene(startMenuPane, width, height);
        startMenuPane.setPadding(new Insets(450, 250, 250, 250));
        startMenuPane.setVgap(10);
        startMenuPane.setHgap(10);

        Button ct = new Button("Counter terrorist");
        ct.setStyle("-fx-pref-width: 200px;");
        ct.setOnAction(e -> {
            game.getCt().add(new CounterTerrorist(80, 150));
            stage.setScene(gunMenuScene);
        });
        startMenuPane.add(ct, 0, 0);

        Button t = new Button("Terrorist");
        t.setStyle("-fx-pref-width: 200px;");
        t.setOnAction(e -> {
            game.getT().add(new Terrorist(750, 200));
            stage.setScene(gunMenuScene);
        });
        startMenuPane.add(t, 1, 0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}