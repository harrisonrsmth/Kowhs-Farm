package ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class HelpScreen {

    private Scene helpScene;
    private Button helpBackButton;

    public HelpScreen() {
        BorderPane helpRoot = new BorderPane();
        BorderPane helpScreen = new BorderPane();
        StackPane helpCenter = new StackPane();
        helpCenter.setAlignment(Pos.CENTER);
        helpScreen.setCenter(helpCenter);
        helpScreen.setStyle("-fx-background-color: white");
        helpScreen.setMaxHeight(500);
        helpScreen.setMaxWidth(500);
        helpRoot.setCenter(helpScreen);
        helpRoot.setPrefWidth(200);

        Label helpLabel = new Label("Game instructions coming\n soon!");
        helpLabel.setFont(new Font("Arial", 40));

        Button helpBack = new Button("Back");
        helpBack.setFont(new Font("Arial", 30));
        helpBack.setStyle("-fx-background-color: mediumblue; -fx-text-fill: "
                + "white; -fx-border-radius: 30; -fx-background-radius: 30; "
                + "-fx-pref-width: 150");
        helpBack.setId("helpBack");
        helpScreen.setBottom(helpBack);
        BorderPane.setAlignment(helpBack, Pos.CENTER);
        helpBackButton = helpBack;

        Background background = ScreenBackground.createBackground(
                "/backgroundWithoutText.jpg", 2700, 2700);

        helpCenter.getChildren().add(helpLabel);
        helpRoot.setBackground(background);

        helpScene = new Scene(helpRoot, 800, 800);
    }

    public Scene getHelpScene() {
        return helpScene;
    }

    public Button getHelpBackButton() {
        return helpBackButton;
    }
}
