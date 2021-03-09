package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class WinScreen {

    private Scene winScene;
    private Button restartButton;

    public WinScreen() {
        VBox winRoot = new VBox(50);
        winRoot.setAlignment(Pos.CENTER);
        winRoot.setPadding(new Insets(0, 0, 100, 0));

        Label title = new Label("You win!");
        title.setFont(new Font("Arial Rounded MT Bold", 80));
        title.setStyle("-fx-font-weight: BOLD;");

        Label desc = new Label("You successfully harvested 3 of\n"
                + "of each different kind of crop!");
        desc.setFont(new Font("Arial Rounded MT", 40));

        Button restart = new Button("Restart Game");
        restart.setFont(new Font("Arial", 30));
        restart.setStyle("-fx-background-color: mediumblue; -fx-text-fill: "
                + "white; -fx-border-radius: 30; -fx-background-radius: 30; "
                + "-fx-pref-width: 350");
        restart.setId("startButton");
        restartButton = restart;

        Background background = ScreenBackground.createBackground(
                "/backgroundWithoutText.jpg", 2700, 2700);

        winRoot.setBackground(background);
        winRoot.getChildren().addAll(title, desc, restartButton);
        winScene = new Scene(winRoot, 800, 800);
    }

    public Scene getWinScene() {
        return winScene;
    }

    public Button getRestartButton() {
        return restartButton;
    }
}
