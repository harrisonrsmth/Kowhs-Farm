package crop;

import javafx.scene.shape.Circle;

public class RiceSeed extends Seed {

    public RiceSeed() {
        type = "Rice Seed";
        cropType = "Rice";
        basePrice = 5;
        icon = new Circle(40);
        icon.setStyle("-fx-fill: beige; -fx-stroke: black; "
                + "-fx-stroke-width: 5");
    }
}
