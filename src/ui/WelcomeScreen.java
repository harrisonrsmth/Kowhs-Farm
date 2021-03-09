package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class WelcomeScreen {

    private Scene welcomeScene;
    private Button startButton;
    private Button helpButton;

    public WelcomeScreen() {
        VBox welcomeRoot = new VBox(10);
        welcomeRoot.setAlignment(Pos.CENTER);
        welcomeRoot.setPadding(new Insets(160, 0, 0, 0));

        Label title = new Label("Kowh's Farm");
        title.setFont(new Font("Arial Rounded MT Bold", 80));
        title.setStyle("-fx-font-weight: BOLD;");

        Button start = new Button("Start");
        start.setFont(new Font("Arial", 30));
        start.setStyle("-fx-background-color: mediumblue; -fx-text-fill: "
                + "white; -fx-border-radius: 30; -fx-background-radius: 30; "
                + "-fx-pref-width: 150");
        start.setId("startButton");
        startButton = start;

        Button help = new Button("help");
        help.setFont(new Font("Arial", 30));
        help.setStyle("-fx-background-color: transparent; -fx-text-fill: "
                + "black");
        help.setId("helpButton");
        helpButton = help;

        Background background = ScreenBackground.createBackground(
                "/backgroundWithText.jpg", 2700, 2700);

        welcomeRoot.getChildren().addAll(start, help);
        welcomeRoot.setBackground(background);

        welcomeScene = new Scene(welcomeRoot, 800, 800);
    }

    public Scene getWelcomeScene() {
        return welcomeScene;
    }

    public Button getStartButton() {
        return startButton;
    }

    public Button getHelpButton() {
        return helpButton;
    }
}
