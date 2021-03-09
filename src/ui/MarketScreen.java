package ui;

import crop.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.GamePlay;
import main.Market;

public class MarketScreen {

    private VBox marketScreen;


    public MarketScreen(GamePlay game, InventoryTab inventoryTab, Market market) {

        marketScreen = new VBox();

        HBox cornButtons = createMarketPlant("Corn", market, game, inventoryTab);
        HBox wheatButtons = createMarketPlant("Wheat", market, game, inventoryTab);
        HBox riceButtons = createMarketPlant("Rice", market, game, inventoryTab);

        Text fertilizerText = new Text("Fertilizer");
        styleText(fertilizerText);
        Button buyFertilizer = new Button("Buy: " + market.fertilizerPrice());
        buyFertilizer.setId("buyFertilizer");
        styleButton(buyFertilizer);
        buyFertilizer.setOnAction(e -> market.buyFertilizer(game.getInventory(), inventoryTab));
        HBox fertilizerButtons = new HBox(fertilizerText, buyFertilizer);
        styleHBox(fertilizerButtons);

        Text pesticideText = new Text("Pesticide");
        styleText(pesticideText);
        Button buyPesticide = new Button("Buy: " + market.pesticidePrice());
        buyPesticide.setId("buyPesticide");
        styleButton(buyPesticide);
        buyPesticide.setOnAction(e -> market.buyPesticide(game.getInventory(), inventoryTab));
        HBox pesticideButtons = new HBox(pesticideText, buyPesticide);
        styleHBox(pesticideButtons);

        Text beginnerText = new Text("Beginner Worker");
        styleText(beginnerText);
        Button hireBeginner = new Button("Hire: " + market.beginnerWage());
        hireBeginner.setId("hireBeginner");
        styleButton(hireBeginner);
        hireBeginner.setOnAction(e -> market.hireBeginner(game.getInventory(), inventoryTab));
        HBox beginnerButton = new HBox(beginnerText, hireBeginner);
        styleHBox(beginnerButton);

        Text expertText = new Text("Expert Worker");
        styleText(expertText);
        Button hireExpert = new Button("Hire: " + market.expertWage());
        hireExpert.setId("hireExpert");
        styleButton(hireExpert);
        hireExpert.setOnAction(e -> market.hireExpert(game.getInventory(), inventoryTab));
        HBox expertButton = new HBox(expertText, hireExpert);
        styleHBox(expertButton);

        Text tractorText = new Text("Tractor");
        styleText(tractorText);
        Button buyTractor = new Button("Buy: 20");
        buyTractor.setId("buyTractor");
        styleButton(buyTractor);
        buyTractor.setOnAction(e -> market.buyTractor(game.getInventory(), inventoryTab));
        HBox tractorButton = new HBox(tractorText, buyTractor);
        styleHBox(tractorButton);

        Text irrigationText = new Text("Irrigation");
        styleText(irrigationText);
        Button buyIrrigation = new Button("Buy: 20");
        buyIrrigation.setId("buyIrrigation");
        styleButton(buyIrrigation);
        buyIrrigation.setOnAction(e -> market.buyIrrigation(game.getInventory(), inventoryTab));
        HBox irrigationButton = new HBox(irrigationText, buyIrrigation);
        styleHBox(irrigationButton);

        Text plotText = new Text("Plot");
        styleText(plotText);
        Button buyPlot = new Button("Buy: " + market.plotPrice());
        buyPlot.setId("buyPlot");
        styleButton(buyPlot);
        buyPlot.setOnAction(e ->  {
            market.buyPlot(inventoryTab);
            buyPlot.setText("Buy: " + market.plotPrice());
        });
        HBox plotButtons = new HBox(plotText, buyPlot);
        styleHBox(plotButtons);

        VBox buttonsBox = new VBox(cornButtons, wheatButtons, riceButtons, fertilizerButtons,
                pesticideButtons, beginnerButton, expertButton, tractorButton, irrigationButton,
                plotButtons);
        buttonsBox.setPadding(new Insets(10));
        buttonsBox.setAlignment(Pos.CENTER);

        buttonsBox.setBorder(new Border(new BorderStroke(Color.WHEAT,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));

        Background wood = ScreenBackground.createBackground(
                "https://pngtree.com/freepng/vector-wood-background_784161.html",
                700, 700);
        marketScreen = new VBox();
        marketScreen.setBackground(wood);

        marketScreen.getChildren().addAll(buttonsBox);
    }

    private HBox createMarketPlant(String name, Market market, GamePlay game,
                                  InventoryTab inventoryTab) {
        int i;
        switch (name) {
        case "Corn": i = 0;
        break;
        case "Wheat": i = 1;
        break;
        default: i = 2;
        }

        Text text = new Text(name);
        styleText(text);
        Button buy = new Button("Buy: " + market.seedPrice(Seed.getSeeds()[i]));
        buy.setId("buy" + name);
        styleButton(buy);
        buy.setOnAction(e -> market.buySeed(game.getInventory(),
                Seed.getSeeds()[i], inventoryTab));

        Button sell =
                new Button("Sell: " + market.cropPrice(Crop.getCrops()[i]));
        sell.setId("sell" + name);
        styleButton(sell);
        sell.setOnAction(e -> market.sellCrop(game.getInventory(),
                Crop.getCrops()[i], inventoryTab));
        HBox buttons = new HBox(text, buy, sell);
        styleHBox(buttons);
        return buttons;
    }

    private void styleButton(Button button) {
        button.setStyle("-fx-background-color: saddlebrown; -fx-text-fill: "
                + "white; -fx-border-radius: 30; -fx-background-radius: 30; "
                + "-fx-pref-width: 100");
    }

    private void styleHBox(HBox hBox) {
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(10);
        hBox.setBorder(new Border(new BorderStroke(Color.WHEAT,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
    }

    private void styleText(Text text) {
        text.setFont(Font.font("Verdana", 20));
        text.setFill(Color.SADDLEBROWN);
    }

    public VBox getMarket() {
        return marketScreen; }


}
