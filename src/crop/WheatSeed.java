package crop;

import javafx.scene.shape.Circle;

public class WheatSeed extends Seed {

    public WheatSeed() {
        type = "Wheat Seed";
        cropType = "Wheat";
        basePrice = 10;
        icon = new Circle(40);
        icon.setStyle("-fx-fill: tan; -fx-stroke: sienna; "
                + "-fx-stroke-width: 5");
    }
}
