package ui;

import crop.BeginnerWorker;
import crop.ExpertWorker;
import crop.FarmWorker;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.GamePlay;
import main.GrowthCycle;
import main.Market;
import main.Plot;
import main.RandomEvents;

import java.util.ArrayList;

public class FarmScreen {

    private Scene farmScene;
    private InventoryTab inventoryTab;
    private Button goToMarket;
    private BorderPane titles;
    private MarketScreen marketScreen;
    private BorderPane root;
    private Button time;
    private GamePlay game;
    private HBox buttons;
    private RandomEvents randomEvents;
    private VBox middle;


    public FarmScreen(GamePlay game, Market market) {
        root = new BorderPane();
        titles = new BorderPane();
        this.game = game;
        this.middle = new VBox();

        Background path = ScreenBackground.createBackground("path.png", 500, 500);
        middle.setBackground(path);
        root.setCenter(middle);

        inventoryTab = new InventoryTab(game);

        VBox s1 = new VBox(10d);

        createPlot(middle, 1, s1);
        createPlot(middle, 2, s1);
        createPlot(middle, 3, s1);
        createPlot(middle, 4, s1);
        createPlot(middle, 5, s1);

        s1.setBackground(path);
        root.setLeft(s1);

        VBox s2 = new VBox(10d);
        s2.setBackground(path);
        root.setRight(s2);

        this.randomEvents = new RandomEvents(game);

        goToMarket = new Button("Go To Market");
        goToMarket.setId("goToMarket");

        goToMarket.setStyle("-fx-background-color: saddlebrown; -fx-text-fill: "
                + "white; -fx-border-radius: 30; -fx-background-radius: 30; "
                + "-fx-pref-width: 150");

        //transfers between farm and market screen
        marketScreen = new MarketScreen(game, inventoryTab, market);
        goToMarket.setOnAction(e -> {
            if (goToMarket.getText().equals("Go To Market")) {
                root.setCenter(marketScreen.getMarket());
                goToMarket.setText("Go to Farm");
            } else {
                root.setCenter(middle);
                goToMarket.setText("Go To Market");
            }
        });

        // time button
        time = new Button("Increase Time");
        time.setId("increaseTime");
        time.setStyle("-fx-background-color: saddlebrown; -fx-text-fill: "
                + "white; -fx-border-radius: 30; -fx-background-radius: 30; "
                + "-fx-pref-width: 150");

        time.setOnAction(e -> updateTime());

        HBox buttons = new HBox(goToMarket, time);
        this.buttons = buttons;

        root.setBottom(inventoryTab.getInventoryTab());

        updateTitle(game, titles, buttons);

        root.setTop(titles);

        farmScene = new Scene(root, 800, 800);
    }

    public void createPlot(VBox middle, int num, VBox side) {
        Plot plot = new Plot(game.getInventory(), inventoryTab, game);
        plot.setId("plot" + num);
        plot.getHarvest().setOnAction(e -> plot.harvest(false));
        plot.getHarvest().setId("harvest" + num);
        plot.getPlant().setOnAction(e -> root.setCenter(new SeedScreen(root,
                plot, middle).getSeedScreen()));
        plot.getPlant().setId("plant" + num);
        plot.getWater().setOnAction(e -> plot.water());
        plot.getWater().setId("water" + num);
        plot.getFertilize().setOnAction(e -> plot.fertilize());
        plot.getFertilize().setId("fertilize" + num);
        plot.getPesticide().setOnAction(e -> plot.sprayPesticide());
        plot.getPesticide().setId("pesticide" + num);
        game.getPlotArray().add(plot);
        side.getChildren().add(plot);
    }

    private void updateTime() {
        game.setDay(game.getDay() + 1);
        game.setPlotsHarvested(0);
        game.setPlotsWatered(0);
        randomEvents.wreakHavoc();
        for (int i = 0; i < game.getPlotArray().size(); i++) {
            Plot plot = game.getPlotArray().get(i);
            plot.grow();
        }

        ArrayList<Integer> toDelete = new ArrayList<>();
        int id = 0;
        for (FarmWorker worker : game.getInventory().getWorkers()) {
            worker.work(game, inventoryTab, toDelete, id);
            id++;
        }
        for (int i : toDelete) {
            game.getInventory().getWorkers().get(i).deleteWorker(game, inventoryTab);
        }
        inventoryTab.updateInventory(game.getInventory());
        updateTitle(game, titles, buttons);
    }

    public void updateTitle(GamePlay game, BorderPane titles, HBox buttons) {
        titles.getChildren().clear();
        Text moneyText = new Text(" Money: " + game.getMoney());
        Text daysText = new Text("Day: " + game.getDay() + " ");
        Label goal = new Label("Harvest 3 of each crop to win!");
        goal.setStyle("-fx-font-weight: bold");
        goal.setFont(Font.font("Arial", 20));
        Label current = new Label("Corn: " + game.getCornCount()
                + "      Wheat: " + game.getWheatCount()
                + "      Rice: " + game.getRiceCount());
        goal.setFont(Font.font("Arial", 18));
        titles.setLeft(moneyText);
        titles.setRight(daysText);
        titles.setCenter(buttons);
        VBox bottom = new VBox(goal, current);
        bottom.setAlignment(Pos.CENTER);
        titles.setBottom(bottom);
        buttons.setAlignment(Pos.TOP_CENTER);

        int flag = 0;

        for (int i = 0; i < game.getPlotArray().size(); i++) {
            Plot plot = game.getPlotArray().get(i);
            if (plot.getGrowthCycle().getCurrentCycle().equals(GrowthCycle.DEAD)
                    || plot.getGrowthCycle().getCurrentCycle().equals(GrowthCycle.EMPTY)) {
                flag++;
            }
        }

        if (flag == game.getPlotArray().size() && game.getMoney() == 0
                && game.getInventory().getSeedAmount() == 0
                && game.getInventory().getCropAmount() == 0) {
            KowhsFarmUIController.endScreen();
        }
    }

    public Scene getFarmScene() {
        return farmScene;
    }

    public InventoryTab getInventoryTab() {
        return inventoryTab;
    }

    public BorderPane getTitles() {
        return titles;
    }

    public Button getGoToMarket() {
        return goToMarket;
    }

    public HBox getButtonHbox() {
        return buttons;
    }

    public MarketScreen getMarketScreen() {
        return marketScreen;
    }

    public BorderPane getRoot() {
        return root;
    }

    public VBox getMiddle() {
        return middle;
    }
}
