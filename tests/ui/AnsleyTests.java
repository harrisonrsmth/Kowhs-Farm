package ui;

//import crop.Seed;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
//import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.GrowthCycle;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
//import org.testfx.util.WaitForAsyncUtils;

public class AnsleyTests extends ApplicationTest {

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

    /*@Test
    public void testEasyInitialization() {
        clickOn("#startButton");
        clickOn("#easy");
        WaitForAsyncUtils.waitForFxEvents();

        Assert.assertEquals("Easy", KowhsFarmUIController.getGame().getDifficulty());
    }

    @Test
    public void testMediumInitialization() {
        clickOn("#startButton");
        clickOn("#medium");
        WaitForAsyncUtils.waitForFxEvents();

        Assert.assertEquals("Medium", KowhsFarmUIController.getGame().getDifficulty());
    }

    @Test
    public void testHardInitialization() {
        clickOn("#startButton");
        clickOn("#hard");
        WaitForAsyncUtils.waitForFxEvents();

        Assert.assertEquals("Hard", KowhsFarmUIController.getGame().getDifficulty());
    }

    @Test
    public void testCornInitialization() {
        clickOn("#startButton");
        clickOn("#corn");
        WaitForAsyncUtils.waitForFxEvents();

        Assert.assertEquals(Seed.getSeeds()[0],
                KowhsFarmUIController.getGame().getStartingSeed());
    }

    @Test
    public void testWheatInitialization() {
        clickOn("#startButton");
        clickOn("#wheat");
        WaitForAsyncUtils.waitForFxEvents();

        Assert.assertEquals(Seed.getSeeds()[1],
                KowhsFarmUIController.getGame().getStartingSeed());
    }

    @Test
    public void testRiceInitialization() {
        clickOn("#startButton");
        clickOn("#rice");
        WaitForAsyncUtils.waitForFxEvents();

        Assert.assertEquals(Seed.getSeeds()[2],
                KowhsFarmUIController.getGame().getStartingSeed());
    }*/
    /*
    @Test
    public void  testGoToMarketButton() {
        clickOn("#startButton");
        clickOn("#name");
        write("Test Name");
        clickOn("#nextButton");
        clickOn("#goToMarket");
        WaitForAsyncUtils.waitForFxEvents();

        BorderPane root = (BorderPane) KowhsFarmUIController.getFarmScreen().getFarmScene()
                .getRoot();
        Assert.assertEquals(KowhsFarmUIController.getFarmScreen().getMarketScreen().getMarket(),
                root.getCenter());
    }

    @Test
    public void  testGoToFarmButton() {
        clickOn("#startButton");
        clickOn("#name");
        write("Test Name");
        clickOn("#nextButton");
        clickOn("#goToMarket");
        clickOn("#goToMarket");
        WaitForAsyncUtils.waitForFxEvents();

        BorderPane root = (BorderPane) KowhsFarmUIController.getFarmScreen()
                .getFarmScene().getRoot();
        Assert.assertEquals(((BorderPane) KowhsFarmUIController.getFarmScreen().getFarmScene()
                .getRoot()).getCenter(), root.getCenter());
    }*/

    //M5
    @Test
    public void testPesticideCropSalePrice() {
        clickOn("#startButton");
        clickOn("#name");
        write("Test Name");
        clickOn("#nextButton");
        clickOn("#goToMarket");
        clickOn("#buyPesticide");
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
        clickOn("#plot1");
        clickOn("#pesticide1");
        clickOn("#increaseTime");
        clickOn("#increaseTime");
        clickOn("#increaseTime");
        clickOn("#plot1");
        clickOn("#harvest1");
        clickOn("#goToMarket");
        clickOn("#sellCorn");

        Assert.assertEquals(KowhsFarmUIController.getGame().getMoney(), 160);

    }

    @Test
    public void testPesticideCropProtected() {
        clickOn("#startButton");
        clickOn("#name");
        write("Test Name");
        clickOn("#nextButton");
        clickOn("#increaseTime"); //day1-2
        clickOn("#increaseTime"); //day2-3
        clickOn("#increaseTime"); //day3-4
        clickOn("#increaseTime"); //day4-5
        //day5
        clickOn("#goToMarket");
        clickOn("#buyPesticide");
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
        clickOn("#pesticide1");
        clickOn("#increaseTime"); //day5-6
        clickOn("#increaseTime"); //day6-7

        Assert.assertEquals(KowhsFarmUIController.getGame().getPlotArray().get(0)
                .getGrowthCycle().getCurrentCycle(), GrowthCycle.IMMATURE2);

    }

}