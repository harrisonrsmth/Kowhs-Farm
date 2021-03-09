package ui;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import main.GrowthCycle;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

public class HarrisonTests extends ApplicationTest {

    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        KowhsFarmUIController uiController = new KowhsFarmUIController();
        uiController.start(stage);
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    //M2 tests
    /*@Test
    public void testNameInitialization() {
        clickOn("#startButton");
        clickOn("#name");
        write("Test Name");
        WaitForAsyncUtils.waitForFxEvents();

        Assert.assertEquals("Test Name",
                KowhsFarmUIController.getGame().getName());
    }

    @Test
    public void testValidNameProcedure() {
        clickOn("#startButton");
        clickOn("#name");
        write("Test Name");
        clickOn("#nextButton");
        WaitForAsyncUtils.waitForFxEvents();

        Assert.assertEquals(KowhsFarmUIController.getFarmScreen().getFarmScene(),
                stage.getScene());
    }

    @Test
    public void testInvalidNameProcedure() {
        clickOn("#startButton");
        clickOn("#nextButton");
        WaitForAsyncUtils.waitForFxEvents();

        Assert.assertEquals(KowhsFarmUIController.getConfigScreen().getConfigScene(),
                stage.getScene());
    }

    @Test
    public void testBlankNameProcedure() {
        clickOn("#startButton");
        clickOn("#name");
        write("     ");
        clickOn("#nextButton");

        Assert.assertEquals(KowhsFarmUIController.getConfigScreen().getConfigScene(),
                stage.getScene());
    }*/

    //M3 tests
    /*@Test
    public void testStartingSeedDefaultInInventory() {
        clickOn("#startButton");
        clickOn("#name");
        write("Test Name");
        clickOn("#nextButton");
        WaitForAsyncUtils.waitForFxEvents();

        int actualCorn =
                KowhsFarmUIController.getGame().getInventory().getSeedMap().get(Seed.getSeeds()[0]);
        int actualWheat =
                KowhsFarmUIController.getGame().getInventory().getSeedMap().get(Seed.getSeeds()[1]);
        int actualRice =
                KowhsFarmUIController.getGame().getInventory().getSeedMap().get(Seed.getSeeds()[2]);
        Assert.assertEquals(2, actualCorn);
        Assert.assertEquals(0, actualWheat);
        Assert.assertEquals(0, actualRice);
    }

    @Test
    public void testStartingSeedSelectionInInventory() {
        clickOn("#startButton");
        clickOn("#name");
        write("Test Name");
        clickOn("#wheat");
        clickOn("#nextButton");
        WaitForAsyncUtils.waitForFxEvents();

        int actualCorn =
                KowhsFarmUIController.getGame().getInventory().getSeedMap().get(Seed.getSeeds()[0]);
        int actualWheat =
                KowhsFarmUIController.getGame().getInventory().getSeedMap().get(Seed.getSeeds()[1]);
        int actualRice =
                KowhsFarmUIController.getGame().getInventory().getSeedMap().get(Seed.getSeeds()[2]);
        Assert.assertEquals(0, actualCorn);
        Assert.assertEquals(2, actualWheat);
        Assert.assertEquals(0, actualRice);
    }

    @Test
    public void testStartingSeedInInventoryTab() {
        clickOn("#startButton");
        clickOn("#name");
        write("Test Name");
        clickOn("#nextButton");
        WaitForAsyncUtils.waitForFxEvents();

        int actual = KowhsFarmUIController.getFarmScreen().getInventoryTab().getInventoryHBox()
                .getChildren().size();
        Assert.assertEquals(1, actual);
    }*/

    //M4 Tests
    /*@Test
    public void testWaterPlantSuccessful() {
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
        WaitForAsyncUtils.waitForFxEvents();

        Assert.assertEquals(1,
                KowhsFarmUIController.getGame().getPlotArray().get(0).getWaterLevel());
    }

    @Test
    public void testOverWater() {
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
        clickOn("#plot1");
        clickOn("#water1");
        clickOn("#plot1");
        clickOn("#water1");
        WaitForAsyncUtils.waitForFxEvents();

        Assert.assertEquals(GrowthCycle.DEAD,
                KowhsFarmUIController.getGame().getPlotArray().get(0).getGrowthCycle()
                        .getCurrentCycle());
    }*/
    //M6
    @Test
    public void testInitialPlots() {
        clickOn("#startButton");
        clickOn("#name");
        write("Test Name");
        clickOn("#nextButton");
        WaitForAsyncUtils.waitForFxEvents();

        Assert.assertEquals(5,
                KowhsFarmUIController.getGame().getPlotArray().size());
    }

    @Test
    public void testBuyPlot() {
        clickOn("#startButton");
        clickOn("#name");
        write("Test Name");
        clickOn("#nextButton");
        clickOn("#goToMarket");
        clickOn("#buyPlot");
        WaitForAsyncUtils.waitForFxEvents();

        Assert.assertEquals(6,
                KowhsFarmUIController.getGame().getPlotArray().size());
    }

    @Test
    public void testPlotPriceIncrease() {
        clickOn("#startButton");
        clickOn("#name");
        write("Test Name");
        clickOn("#nextButton");
        clickOn("#goToMarket");
        clickOn("#buyPlot");
        WaitForAsyncUtils.waitForFxEvents();

        Assert.assertEquals(60,
                KowhsFarmUIController.getMarket().plotPrice());
    }
}