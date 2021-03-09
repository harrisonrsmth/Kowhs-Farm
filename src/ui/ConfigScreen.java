package ui;

import crop.Seed;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import main.GamePlay;


public class ConfigScreen {

    private Scene configScene;
    private Button nextButton;
    private GamePlay game;

    public ConfigScreen(GamePlay game) {

        BorderPane configRoot = new BorderPane();
        this.game = game;

        //name
        Label nameLabel = new Label("Name: ");
        nameLabel.setFont(new Font("Helvetica", 18));
        TextField name = new TextField();
        name.setPromptText("Enter your name.");
        game.setName(name.getText());
        name.setId("name");
        HBox nameHBox = new HBox();

        name.setOnKeyReleased(e -> game.setName(name.getText().replaceAll(
                "^[ \t]+|[ \t]+$", "")));

        nameHBox.getChildren().addAll(nameLabel, name);
        nameHBox.setAlignment(Pos.CENTER);


        //difficulty
        Label difficultyLevel = new Label("Difficulty Level: ");
        difficultyLevel.setFont(new Font("Helvetica", 18));
        //radio buttons
        RadioButton rbEasy = new RadioButton("Easy");
        rbEasy.setId("easy");
        RadioButton rbMedium = new RadioButton("Medium");
        rbMedium.setId("medium");
        RadioButton rbHard = new RadioButton("Hard");
        rbHard.setId("hard");
        final ToggleGroup group = new ToggleGroup();
        group.getToggles().addAll(rbEasy, rbMedium, rbHard);
        rbEasy.setSelected(true);
        HBox diffBox = new HBox();

        rbEasy.setOnAction(e -> game.setDifficulty("Easy", 100));
        rbMedium.setOnAction(e -> game.setDifficulty("Medium", 50));
        rbHard.setOnAction(e -> game.setDifficulty("Hard", 20));
        diffBox.getChildren().addAll(rbEasy, rbMedium, rbHard);
        diffBox.setAlignment(Pos.CENTER);

        //seedType
        Label seedTypeLabel = new Label("Seed Type: ");
        seedTypeLabel.setFont(new Font("Helvetica", 18));
        //radio
        RadioButton cornBtn = new RadioButton("Corn");
        cornBtn.setId("corn");
        RadioButton wheatBtn = new RadioButton("Wheat");
        wheatBtn.setId("wheat");
        RadioButton riceBtn = new RadioButton("Rice");
        riceBtn.setId("rice");
        final ToggleGroup group2 = new ToggleGroup();
        group2.getToggles().addAll(cornBtn, wheatBtn, riceBtn);
        cornBtn.setSelected(true);
        cornBtn.setOnAction(e -> game.setStartingSeed(Seed.getSeeds()[0]));
        wheatBtn.setOnAction(e -> game.setStartingSeed(Seed.getSeeds()[1]));
        riceBtn.setOnAction(e -> game.setStartingSeed(Seed.getSeeds()[2]));
        //HBox
        HBox seedHBox = new HBox();
        seedHBox.getChildren().addAll(cornBtn, wheatBtn, riceBtn);
        seedHBox.setSpacing(10);
        seedHBox.setAlignment(Pos.CENTER);



        //Season
        Label seasonLabel = new Label("Season: ");
        seasonLabel.setFont(new Font("Helvetica", 18));
        //radio
        RadioButton spring = new RadioButton("Spring");
        spring.setId("spring");
        RadioButton summer = new RadioButton("Summer");
        summer.setId("summer");
        RadioButton fall = new RadioButton("Fall");
        fall.setId("fall");
        RadioButton winter = new RadioButton("Winter");
        winter.setId("winter");
        final ToggleGroup group3 = new ToggleGroup();
        group3.getToggles().addAll(spring, summer, fall, winter);
        spring.setSelected(true);
        spring.setOnAction(e -> game.setSeason("Spring"));
        summer.setOnAction(e -> game.setSeason("Summer"));
        fall.setOnAction(e -> game.setSeason("Fall"));
        winter.setOnAction(e -> game.setSeason("Winter"));


        //HBox
        HBox seasonHBox = new HBox();
        seasonHBox.getChildren().addAll(spring, summer, fall, winter);
        seasonHBox.setSpacing(10);
        seasonHBox.setAlignment(Pos.CENTER);


        Button next = new Button("Next");
        next.setStyle("-fx-background-color: mediumblue; -fx-text-fill: "
                + "white; -fx-border-radius: 30; -fx-background-radius: 30; "
                + "-fx-pref-width: 150");
        next.setId("nextButton");
        nextButton = next;

        VBox configScreen = new VBox();
        configScreen.setStyle("-fx-background-color: white");
        configScreen.setMaxHeight(500);
        configScreen.setMaxWidth(500);
        configRoot.setCenter(configScreen);
        configRoot.setPrefWidth(200);
        configScreen.setSpacing(15);
        configScreen.setAlignment(Pos.CENTER);


        configScreen.getChildren().addAll(nameHBox, difficultyLevel, diffBox,
                seedTypeLabel, seedHBox, seasonLabel, seasonHBox, next);


        // set background
        Background background = ScreenBackground.createBackground(
                "/backgroundWithoutText.jpg", 2700, 2700);
        configRoot.setBackground(background);


        configScene = new Scene(configRoot, 800, 800);
    }

    public Scene getConfigScene() {
        return configScene;
    }

    public Button getNextButton() {
        return nextButton;
    }

    public GamePlay getGame() {
        return game;
    }
}
