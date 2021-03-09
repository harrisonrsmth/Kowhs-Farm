package crop;

import javafx.scene.shape.Rectangle;

public class Corn extends Crop {

    public Corn(String maturity) {
        type = "Corn";
        basePrice = 70;
        growthStage = maturity;
        icon = new Rectangle(80, 80);
        icon.setStyle("-fx-fill: gold; -fx-stroke: goldenrod; "
                + "-fx-stroke-width: 5");
        numWithPesticide = 0;
    }

    public Corn() {
        this("Seed");
    }
}