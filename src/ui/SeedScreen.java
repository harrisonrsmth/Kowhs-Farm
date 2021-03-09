package ui;

import crop.Seed;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.Plot;

public class SeedScreen {

    private VBox seedScreen;
    private Seed seed;


    public SeedScreen(BorderPane root, Plot plot, Node last) {

        seedScreen = new VBox();

        //Crops
        Text cornText = new Text("Corn");
        cornText.setFont(Font.font("Verdana", 20));
        cornText.setFill(Color.SADDLEBROWN);
        Text wheatText = new Text("Wheat");
        wheatText.setFont(Font.font("Verdana", 20));
        wheatText.setFill(Color.SADDLEBROWN);
        Text riceText = new Text("Rice");
        riceText.setFont(Font.font("Verdana", 20));
        riceText.setFill(Color.SADDLEBROWN);

        //Corn
        Button plantCorn = new Button("Select");
        plantCorn.setId("plantCorn");

        plantCorn.setStyle("-fx-background-color: saddlebrown; -fx-text-fill: "
                + "white; -fx-border-radius: 30; -fx-background-radius: 30; "
                + "-fx-pref-width: 100");
        plantCorn.setOnAction(e -> seed = Seed.getSeeds()[0]);


        //Wheat
        Button plantWheat = new Button("Select");
        plantWheat.setId("plantWheat");

        plantWheat.setStyle("-fx-background-color: saddlebrown; -fx-text-fill: "
                + "white; -fx-border-radius: 30; -fx-background-radius: 30; "
                + "-fx-pref-width: 100");
        plantWheat.setOnAction(e -> seed = Seed.getSeeds()[1]);

        //Rice
        Button plantRice = new Button("Select");
        plantRice.setId("plantRice");

        plantRice.setStyle("-fx-background-color: saddlebrown; -fx-text-fill: "
                + "white; -fx-border-radius: 30; -fx-background-radius: 30; "
                + "-fx-pref-width: 100");
        plantRice.setOnAction(e -> seed = Seed.getSeeds()[2]);

        //Done
        Button done = new Button("Plant");
        done.setId("done");
        done.setStyle("-fx-background-color: saddlebrown; -fx-text-fill: "
                + "white; -fx-border-radius: 30; -fx-background-radius: 30; "
                + "-fx-pref-width: 100");
        done.setOnAction(e ->
                done(plot, seed, root, last)
        );

        // Button Styling/Placement
        HBox cornButtons = new HBox(cornText, plantCorn);
        cornButtons.setPadding(new Insets(10));
        cornButtons.setSpacing(10);
        cornButtons.setBorder(new Border(new BorderStroke(Color.WHEAT,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
        HBox wheatButtons = new HBox(wheatText, plantWheat);
        wheatButtons.setPadding(new Insets(10));
        wheatButtons.setSpacing(10);
        wheatButtons.setBorder(new Border(new BorderStroke(Color.WHEAT,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
        HBox riceButtons = new HBox(riceText, plantRice);
        riceButtons.setPadding(new Insets(10));
        riceButtons.setSpacing(10);
        riceButtons.setBorder(new Border(new BorderStroke(Color.WHEAT,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
        VBox buttonsBox = new VBox(cornButtons, wheatButtons, riceButtons, done);
        buttonsBox.setPadding(new Insets(10));
        buttonsBox.setAlignment(Pos.CENTER);

        buttonsBox.setBorder(new Border(new BorderStroke(Color.WHEAT,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));

        Background wood = ScreenBackground.createBackground(
                "https://pngtree.com/freepng/vector-wood-background_784161.html",
                500, 500);
        seedScreen = new VBox();
        seedScreen.setBackground(wood);

        seedScreen.getChildren().addAll(buttonsBox);
    }

    public VBox getSeedScreen() {
        return seedScreen;
    }
    private void done(Plot plot, Seed seed, BorderPane root, Node last) {
        plot.plant(seed);
        root.setCenter(last);
    }

}
