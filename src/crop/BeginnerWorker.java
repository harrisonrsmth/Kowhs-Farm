package crop;

import javafx.scene.shape.Ellipse;

public class BeginnerWorker extends FarmWorker {

    public BeginnerWorker() {
        plotsLeft = 2;
        icon = new Ellipse(40, 20);
        icon.setStyle("-fx-fill: lightsalmon; -fx-stroke: coral; " + "-fx-stroke-width: 5");
    }
}
