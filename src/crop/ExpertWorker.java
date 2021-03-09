package crop;

import javafx.scene.shape.Ellipse;

public class ExpertWorker extends FarmWorker {

    public ExpertWorker() {
        plotsLeft = 8;
        icon = new Ellipse(40, 20);
        icon.setStyle("-fx-fill: lightpink; -fx-stroke: palevioletred; " + "-fx-stroke-width: 5");
    }
}
