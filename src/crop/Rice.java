package crop;

import javafx.scene.shape.Rectangle;

public class Rice extends Crop {

    public Rice(String maturity) {
        type = "Rice";
        basePrice = 20;
        growthStage = maturity;
        icon = new Rectangle(80, 80);
        icon.setStyle("-fx-fill: beige; -fx-stroke: black; "
                + "-fx-stroke-width: 5");
        numWithPesticide = 0;
    }

    public Rice() {
        this("Seed");
    }
}
