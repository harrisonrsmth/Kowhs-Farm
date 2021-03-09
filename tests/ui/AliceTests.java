package ui;
import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

public class AliceTests extends ApplicationTest {
    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        KowhsFarmUIController uiController = new KowhsFarmUIController();
        uiController.start(stage);
    }
    /*
    @Test
    public void testStartButton() {
        clickOn("#startButton");
        WaitForAsyncUtils.waitForFxEvents();
        Assert.assertEquals(stage.getScene(),
                KowhsFarmUIController.getConfigScreen().getConfigScene());
    }

    @Test
    public void testSummer() {
        clickOn("#startButton");
        clickOn("#summer");
        WaitForAsyncUtils.waitForFxEvents();

        Assert.assertEquals("Summer",
                KowhsFarmUIController.getGame().getSeason());
    }

    @Test
    public void testWinter() {
        clickOn("#startButton");
        clickOn("#winter");
        WaitForAsyncUtils.waitForFxEvents();

        Assert.assertEquals("Winter",
                KowhsFarmUIController.getGame().getSeason());
    }

    @Test
    public void testSpring() {
        clickOn("#startButton");
        clickOn("#spring");
        WaitForAsyncUtils.waitForFxEvents();

        Assert.assertEquals("Spring",
                KowhsFarmUIController.getGame().getSeason());
    }

    @Test
    public void testFall() {
        clickOn("#startButton");
        clickOn("#fall");
        WaitForAsyncUtils.waitForFxEvents();

        Assert.assertEquals("Fall",
                KowhsFarmUIController.getGame().getSeason());
    }*/
    /*
    @Test
    public void testTime() {
        clickOn("#startButton");
        clickOn("#name");
        write("Test Name");
        clickOn("#nextButton");
        clickOn("#plot1");
        clickOn("#plant1");
        clickOn("#plantCorn");
        clickOn("#done");
        clickOn("#plot1");
        clickOn("#water1");

        clickOn("#increaseTime");
        Assert.assertEquals(KowhsFarmUIController.getGame().getDay(), 2);

        Assert.assertEquals(KowhsFarmUIController.getFarmScreen().getPlotArray()[0]
                .getWaterLevel(), 1);

        Assert.assertEquals(KowhsFarmUIController.getFarmScreen().getPlotArray()[0]
                .getGrowthCycle().getCurrentCycle(), "Immature");

        clickOn("#increaseTime");

        Assert.assertEquals(KowhsFarmUIController.getFarmScreen().getPlotArray()[0]
                .getGrowthCycle().getCurrentCycle(), "Dead");

    }
    public void testBeginnerFarmer() {
        clickOn("#startButton");
        clickOn("#name");
        write("Test Name");
        clickOn("#nextButton");
        clickOn("#goToMarket");
        clickOn("#hireBeginner");
        clickOn("#goToMarket");
        clickOn("#plot1");
        clickOn("#plant1");
        clickOn("#plantCorn");
        clickOn("#done");
        clickOn("#plot1");
        clickOn("#water1");
        clickOn("#plot1");
        clickOn("#water1");
        clickOn("#increaseTime");
        clickOn("#increaseTime");
        clickOn("#plot1");
        clickOn("#water1");
        clickOn("#plot1");
        clickOn("#water1");
        clickOn("#plot1");
        clickOn("#water1");
        clickOn("#increaseTime");
        clickOn("#increaseTime");
        clickOn("#increaseTime");

        Assert.assertEquals(KowhsFarmUIController.getGame().getMoney(), 190);
        Assert.assertEquals(KowhsFarmUIController.getGame().getInventory()
                .getWorkers().size(), 1);

     */

    @Test
    public void testEndScreen() {
        clickOn("#startButton");
        clickOn("#name");
        write("Test Name");
        clickOn("#nextButton");
        clickOn("#goToMarket");
        clickOn("#hireBeginner");
        clickOn("#hireBeginner");

        Assert.assertEquals(stage.getScene(), KowhsFarmUIController.getEndScreen().getEndScene());


    }

}
