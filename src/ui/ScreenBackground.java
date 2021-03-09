package ui;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class ScreenBackground {

    public static Background createBackground(String fileName, int width,
                                              int height) {
        Image image = new Image(fileName);

        BackgroundSize backgroundSize = new BackgroundSize(width, height,
                false,
                false, false, false);

        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER, backgroundSize);

        BackgroundImage[] backgroundImages = new BackgroundImage[1];
        backgroundImages[0] = backgroundImage;

        return new Background(backgroundImages);
    }
}
