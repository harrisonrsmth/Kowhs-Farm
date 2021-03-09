package ui;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import static org.junit.Assert.assertEquals;

public class UtibenoTests extends ApplicationTest {

    private Stage stage;

    @Before
    public void setUp() throws Exception {
    }

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        KowhsFarmUIController uiController = new KowhsFarmUIController();
        uiController.start(stage);
    }

    @After
    public void tearDown() throws Exception {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    /*@Test
    public void easyDifficultyMoneyChange() {
        clickOn("#startButton");
        clickOn("#easy");
        clickOn("#nextButton");
        WaitForAsyncUtils.waitForFxEvents();

        assertEquals(100, KowhsFarmUIController.getGame().getMoney());
    }

    @Test
    public void mediumDifficultyMoneyChange() {
        clickOn("#startButton");
        clickOn("#medium");
        clickOn("#nextButton");
        WaitForAsyncUtils.waitForFxEvents();

        assertEquals(50, KowhsFarmUIController.getGame().getMoney());
    }

    @Test
    public void hardDifficultyMoneyChange() {
        clickOn("#startButton");
        clickOn("#hard");
        clickOn("#nextButton");
        WaitForAsyncUtils.waitForFxEvents();

        assertEquals(20, KowhsFarmUIController.getGame().getMoney());
    }

    @Test
    public void checkDay() {
        clickOn("#startButton");
        clickOn("#nextButton");
        WaitForAsyncUtils.waitForFxEvents();

        assertEquals(1, KowhsFarmUIController.getGame().getDay());
    }*/

    //M3 Test
    @Test
    public void inventoryCheckAfterMarket() {
        clickOn("#startButton");
        clickOn("#name");
        write("Test Name");
        clickOn("#nextButton");
        clickOn("#goToMarket");

        clickOn("#buyCorn");
        assertEquals(3, KowhsFarmUIController.getGame().getInventory().getSize());

        clickOn("#buyWheat");
        assertEquals(4, KowhsFarmUIController.getGame().getInventory().getSize());

        clickOn("#buyWheat");
        assertEquals(5, KowhsFarmUIController.getGame().getInventory().getSize());

        assertEquals(60, KowhsFarmUIController.getGame().getMoney());
        WaitForAsyncUtils.waitForFxEvents();

    }

    @Test
    public void restart() {
        clickOn("#startButton");
        clickOn("#name");
        write("Test Name");
        clickOn("#nextButton");
        clickOn("#goToMarket");
        clickOn("#buyPlot");
        clickOn("#buyPesticide");
        clickOn("#buyPesticide");
        clickOn("#buyPesticide");
        clickOn("#buyPesticide");
        clickOn("#buyPesticide");
        clickOn("#plot1");
        clickOn("#plant1");
        clickOn("#plantCorn");
        clickOn("#done");
        clickOn("#plot2");
        clickOn("#plant2");
        clickOn("#plantCorn");
        clickOn("#done");
        clickOn("#increaseTime");
        clickOn("#startButton");
        clickOn("#name");
        write("Test Name");
        clickOn("#nextButton");
    }

}

