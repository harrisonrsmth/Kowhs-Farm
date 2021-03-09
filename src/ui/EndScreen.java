package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class EndScreen {

    private Scene endScene;
    private Button restartButton;

    public EndScreen() {
        VBox endRoot = new VBox(50);
        endRoot.setAlignment(Pos.CENTER);
        endRoot.setPadding(new Insets(0, 0, 100, 0));

        Label title = new Label("You lost!");
        title.setFont(new Font("Arial Rounded MT Bold", 80));
        title.setStyle("-fx-font-weight: BOLD;");

        Button restart = new Button("Restart Game");
        restart.setFont(new Font("Arial", 30));
        restart.setStyle("-fx-background-color: mediumblue; -fx-text-fill: "
                + "white; -fx-border-radius: 30; -fx-background-radius: 30; "
                + "-fx-pref-width: 350");
        restart.setId("startButton");
        restartButton = restart;

        Background background = ScreenBackground.createBackground(
                "/backgroundWithoutText.jpg", 2700, 2700);

        endRoot.getChildren().addAll(title, restart);
        endRoot.setBackground(background);

        endScene = new Scene(endRoot, 800, 800);
    }

    public Scene getEndScene() {
        return endScene;
    }

    public Button getRestartButton() {
        return restartButton;
    }

}
