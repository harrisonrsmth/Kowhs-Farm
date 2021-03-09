package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import main.GamePlay;
import main.Market;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;

public class KowhsFarmUIController extends Application {

    private static WelcomeScreen welcomeScreen;
    private static HelpScreen helpScreen;
    private static ConfigScreen configScreen;
    private static FarmScreen farmScreen;
    private static EndScreen endScreen;
    private static WinScreen winScreen;
    private static GamePlay game;
    private static Market market;
    private static MediaPlayer music;
    private static MediaPlayer victory;
    private static MediaPlayer lose;
    private static Stage stage;
    private static Button nextButton;

    public KowhsFarmUIController() {
    }

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        game = new GamePlay();
        welcomeScreen = new WelcomeScreen();
        endScreen = new EndScreen();
        helpScreen = new HelpScreen();
        configScreen = new ConfigScreen(game);
        winScreen = new WinScreen();

        Scene welcomeScene = welcomeScreen.getWelcomeScene();
        Scene helpScene = helpScreen.getHelpScene();
        Scene configScene = configScreen.getConfigScene();

        Button helpButton = welcomeScreen.getHelpButton();
        helpButton.setOnAction(e -> primaryStage.setScene(helpScene));

        Button helpBackButton = helpScreen.getHelpBackButton();
        helpBackButton.setOnAction(e -> primaryStage.setScene(welcomeScene));

        Button startButton = welcomeScreen.getStartButton();
        startButton.setOnAction(e -> primaryStage.setScene(configScene));
        
        Button loseRestartButton = endScreen.getRestartButton();
        loseRestartButton.setOnAction(e -> {
            game = new GamePlay();
            configScreen = new ConfigScreen(game);
            primaryStage.setScene(configScreen.getConfigScene());
            setUpNextButton(configScreen, primaryStage);
        });

        Button winRestartButton = winScreen.getRestartButton();
        winRestartButton.setOnAction(e -> {
            game = new GamePlay();
            configScreen = new ConfigScreen(game);
            music.stop();
            primaryStage.setScene(configScreen.getConfigScene());
            setUpNextButton(configScreen, primaryStage);
        });

        Button restartButton = endScreen.getRestartButton();
        restartButton.setOnAction(e -> resetGame());

        game = configScreen.getGame();

        setUpNextButton(configScreen, primaryStage);

        //game = finalGame;

        Media sound =
                new Media(new File("src/KowhsFarm.mp3").toURI().toString());
        music = new MediaPlayer(sound);
        music.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                music.seek(Duration.ZERO);
            }
        });
        music.setAutoPlay(true);

        primaryStage.setScene(welcomeScene);
        primaryStage.setTitle("Kowh's Farm");
        primaryStage.show();
    }

    private void setUpNextButton(ConfigScreen configScreen,
                                 Stage primaryStage) {
        nextButton = configScreen.getNextButton();
        nextButton.setOnAction(ee -> {
            if (!(game.getName() == null || game.getName().equals(
                    ""))) {
                market = new Market(game);
                farmScreen = new FarmScreen(game, market);
                Scene farmScene = farmScreen.getFarmScene();
                primaryStage.setScene(farmScene);
            }
        });
    }

    public static void endScreen() {
        Scene endScene = endScreen.getEndScene();
        stage.setScene(endScene);
        music.stop();
        Media sound =
                new Media(new File("src/Lose.mp3").toURI().toString());
        lose = new MediaPlayer(sound);
        lose.setAutoPlay(true);
    }

    public static void winScreen() {
        Scene winScene = winScreen.getWinScene();
        stage.setScene(winScene);
        music.stop();
        Media sound =
                new Media(new File("src/Victory.mp3").toURI().toString());
        victory = new MediaPlayer(sound);
        victory.setAutoPlay(true);
    }

    public static ConfigScreen getConfigScreen() {
        return configScreen;
    }

    public static GamePlay getGame() {
        return game;
    }

    public static HelpScreen getHelpScreen() {
        return helpScreen;
    }

    public static WelcomeScreen getWelcomeScreen() {
        return welcomeScreen;
    }

    public static EndScreen getEndScreen() {
        return endScreen;
    }

    public void resetGame() {
        start(stage);
        stage.setScene(configScreen.getConfigScene());
    }

    public static FarmScreen getFarmScreen() {
        return farmScreen;
    }

    public static Market getMarket() {
        return market;
    }
}
