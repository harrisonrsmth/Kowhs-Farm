package ui;

//import crop.Seed;
import javafx.stage.Stage;
import main.GrowthCycle;
import org.junit.Assert;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
//import org.testfx.util.WaitForAsyncUtils;

public class MatthewTests extends ApplicationTest {

    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        KowhsFarmUIController uiController = new KowhsFarmUIController();
        uiController.start(stage);
    }

    //M1 Tests
    /*@Test
    public void testHelpButton() {
        clickOn("#helpButton");
        WaitForAsyncUtils.waitForFxEvents();
        Assert.assertEquals(stage.getScene(),
                KowhsFarmUIController.getHelpScreen().getHelpScene());
    }
    @Test
    public void testBackButton() {
        clickOn("#helpButton");
        clickOn("#helpBack");
        WaitForAsyncUtils.waitForFxEvents();
        Assert.assertEquals(stage.getScene(),
                KowhsFarmUIController.getWelcomeScreen().getWelcomeScene());

    }
     */
    //M4 Tests
    /*
    @Test
    public void testSeedPlantType() {
        clickOn("#startButton");
        clickOn("#name");
        write("Test Name");
        clickOn("#nextButton");
        clickOn("#plot1");
        clickOn("#plant1");
        clickOn("#plantCorn");
        clickOn("#done");
        WaitForAsyncUtils.waitForFxEvents();
        Assert.assertEquals(KowhsFarmUIController.getFarmScreen().getPlotArray()[0]
                .getCropType().getType(), "Corn");
    }
    @Test
    public void testSeedRemoved() {
        clickOn("#startButton");
        clickOn("#name");
        write("Test Name");
        clickOn("#wheat");
        clickOn("#nextButton");
        clickOn("#plot1");
        clickOn("#plant1");
        clickOn("#plantWheat");
        clickOn("#done");
        WaitForAsyncUtils.waitForFxEvents();
        int seedAmount = KowhsFarmUIController.getGame().getInventory().getSeedMap()
                .get(Seed.getSeeds()[1]);
        Assert.assertEquals(seedAmount, 1);
    }
    @Test
    public void testSeedRequiredToPlant() {
        clickOn("#startButton");
        clickOn("#name");
        write("Test Name");
        clickOn("#rice");
        clickOn("#nextButton");
        clickOn("#plot1");
        clickOn("#plant1");
        clickOn("#plantCorn");
        clickOn("#done");
        clickOn("#plot2");
        clickOn("#plant2");
        clickOn("#plantWheat");
        clickOn("#done");
        clickOn("#plot3");
        clickOn("#plant3");
        clickOn("#plantRice");
        clickOn("#done");
        WaitForAsyncUtils.waitForFxEvents();
        Assert.assertEquals(KowhsFarmUIController.getFarmScreen().getPlotArray()[0].getText(),
                "Empty");
        Assert.assertEquals(KowhsFarmUIController.getFarmScreen().getPlotArray()[1].getText(),
                "Empty");
        Assert.assertEquals(KowhsFarmUIController.getFarmScreen().getPlotArray()[2].getText(),
                "Rice: Seed\nWater: 1/3");
    }

     */
    //M5 Tests
    /*@Test
    public void testFertilizerGrowth() {
        clickOn("#startButton");
        clickOn("#name");
        write("Test Name");
        clickOn("#nextButton");
        clickOn("#plot1");
        clickOn("#plant1");
        clickOn("#plantCorn");
        clickOn("#done");
        clickOn("#goToMarket");
        clickOn("#buyFertilizer");
        clickOn("#goToMarket");
        clickOn("#plot1");
        clickOn("#water1");
        clickOn("#plot1");
        clickOn("#water1");
        clickOn("#plot1");
        clickOn("#fertilize1");
        clickOn("#increaseTime");
        Assert.assertEquals(KowhsFarmUIController.getGame().getPlotArray().get(0)
                        .getGrowthCycle().getCurrentCycle(), GrowthCycle.IMMATURE2);
    }

    @Test
    public void testFertilizerLevel() {
        clickOn("#startButton");
        clickOn("#name");
        write("Test Name");
        clickOn("#nextButton");
        clickOn("#plot1");
        clickOn("#plant1");
        clickOn("#plantCorn");
        clickOn("#done");
        clickOn("#goToMarket");
        clickOn("#buyFertilizer");
        clickOn("#goToMarket");
        clickOn("#plot1");
        clickOn("#water1");
        clickOn("#plot1");
        clickOn("#water1");
        clickOn("#plot1");
        clickOn("#fertilize1");
        Assert.assertEquals(KowhsFarmUIController.getGame().getPlotArray().get(0)
                .getFertilizerLevel(), 1);
        clickOn("#increaseTime");
        Assert.assertEquals(KowhsFarmUIController.getGame().getPlotArray().get(0)
                .getFertilizerLevel(), 0);
    }
    */
    @Test
    public void testTractor() {
        clickOn("#startButton");
        clickOn("#name");
        write("Test Name");
        clickOn("#nextButton");
        clickOn("#goToMarket");
        clickOn("#buyCorn");
        clickOn("#buyTractor");
        clickOn("#goToMarket");
        clickOn("#plot1");
        clickOn("#plant1");
        clickOn("#plantCorn");
        clickOn("#done");
        clickOn("#plot2");
        clickOn("#plant2");
        clickOn("#plantCorn");
        clickOn("#done");
        clickOn("#plot3");
        clickOn("#plant3");
        clickOn("#plantCorn");
        clickOn("#done");
        clickOn("#plot1");
        clickOn("#water1");
        clickOn("#plot2");
        clickOn("#water2");
        clickOn("#plot3");
        clickOn("#water3");
        clickOn("#increaseTime");
        clickOn("#plot1");
        clickOn("#water1");
        clickOn("#plot2");
        clickOn("#water2");
        clickOn("#plot3");
        clickOn("#water3");
        clickOn("#increaseTime");
        clickOn("#plot1");
        clickOn("#water1");
        clickOn("#plot2");
        clickOn("#water2");
        clickOn("#plot3");
        clickOn("#water3");
        clickOn("#increaseTime");
        clickOn("#plot1");
        clickOn("#water1");
        clickOn("#plot2");
        clickOn("#water2");
        clickOn("#plot3");
        clickOn("#water3");
        clickOn("#increaseTime");
        clickOn("#plot1");
        clickOn("#water1");
        clickOn("#plot2");
        clickOn("#water2");
        clickOn("#plot3");
        clickOn("#water3");
        clickOn("#increaseTime");
        clickOn("#plot1");
        clickOn("#harvest1");
        clickOn("#plot2");
        clickOn("#harvest2");
        clickOn("#plot3");
        clickOn("#harvest3");

        Assert.assertEquals(KowhsFarmUIController.getGame().getPlotArray().get(0)
                .getGrowthCycle().getCurrentCycle(), GrowthCycle.EMPTY);
        Assert.assertEquals(KowhsFarmUIController.getGame().getPlotArray().get(1)
                .getGrowthCycle().getCurrentCycle(), GrowthCycle.EMPTY);
        Assert.assertEquals(KowhsFarmUIController.getGame().getPlotArray().get(2)
                .getGrowthCycle().getCurrentCycle(), GrowthCycle.EMPTY);
    }

    @Test
    public void testIrrigation() {
        clickOn("#startButton");
        clickOn("#name");
        write("Test Name");
        clickOn("#nextButton");
        clickOn("#goToMarket");
        clickOn("#buyIrrigation");
        clickOn("#goToMarket");
        clickOn("#plot1");
        clickOn("#plant1");
        clickOn("#plantCorn");
        clickOn("#done");
        clickOn("#plot1");
        clickOn("#water1");
        clickOn("#plot1");
        clickOn("#water1");
        clickOn("#plot1");
        clickOn("#water1");
        clickOn("#plot1");
        clickOn("#water1");
        Assert.assertEquals(KowhsFarmUIController.getGame().getPlotArray().get(0)
                .getWaterLevel(), 4);
    }

}
