package crop;

import javafx.scene.shape.Rectangle;

public class Wheat extends Crop {

    public Wheat(String maturity) {
        type = "Wheat";
        basePrice = 40;
        growthStage = maturity;
        icon = new Rectangle(80, 80);
        icon.setStyle("-fx-fill: tan; -fx-stroke: sienna; "
                + "-fx-stroke-width: 5");
        numWithPesticide = 0;
    }

    public Wheat() {
        this("Seed");
    }


}