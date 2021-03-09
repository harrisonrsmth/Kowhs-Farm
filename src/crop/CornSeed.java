package crop;

import javafx.scene.shape.Circle;

public class CornSeed extends Seed {

    public CornSeed() {
        type = "Corn Seed";
        cropType = "Corn";
        basePrice = 20;
        icon = new Circle(40);
        icon.setStyle("-fx-fill: gold; -fx-stroke: goldenrod; "
                + "-fx-stroke-width: 5");
    }
}
