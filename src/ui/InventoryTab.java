package ui;

import crop.BeginnerWorker;
import crop.Crop;
import crop.ExpertWorker;
import crop.FarmWorker;
import crop.Seed;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import main.GamePlay;
import main.Inventory;
import javafx.scene.control.ScrollPane;

import java.util.Map;
import java.util.Set;

public class InventoryTab {

    private ScrollPane inventoryTab;
    private HBox inventoryHBox;

    public InventoryTab(GamePlay game) {
        inventoryTab = new ScrollPane();
        inventoryTab.setMinHeight(200);
        inventoryTab.setMaxHeight(200);
        inventoryTab.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        inventoryHBox = new HBox(30);
        inventoryHBox.setMinHeight(200);
        inventoryHBox.setMaxHeight(200);
        inventoryHBox.setMinWidth(800);
        inventoryHBox.setPadding(new Insets(30));
        inventoryHBox.setBackground(new Background(new BackgroundFill(Color.rgb(
                219, 205, 164), CornerRadii.EMPTY, Insets.EMPTY)));
        inventoryHBox.setBorder(new Border(new BorderStroke(Color.WHEAT,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));

        updateInventory(game.getInventory());
        updateInventory(game.getInventory());

        inventoryTab.setContent(inventoryHBox);
    }

    public void processAddSeed(Inventory inventory, Seed seed) {
        inventory.addSeed(seed);
        updateInventory(inventory);
    }

    public void processRemoveSeed(Inventory inventory, Seed seed) {
        inventory.removeSeed(seed);
        updateInventory(inventory);
    }

    public void processCropAdd(Inventory inventory, Crop crop) {
        inventory.addCrop(crop);
        updateInventory(inventory);
    }

    public void processCropRemove(Inventory inventory, Crop crop) {
        inventory.removeCrop(crop);
        updateInventory(inventory);
    }

    public void processFertilizerAdd(Inventory inventory) {
        inventory.addFertilizer();
        updateInventory(inventory);
    }
    public void processFertilizerRemove(Inventory inventory) {
        inventory.removeFertilizer();
        updateInventory(inventory);
    }

    public void processPesticideRemove(Inventory inventory) {
        inventory.removePesticide();
        updateInventory(inventory);
    }

    public void processPesticideAdd(Inventory inventory) {
        inventory.addPesticide();
        updateInventory(inventory);
    }

    public void processAddWorker(Inventory inventory, boolean beginner) {
        inventory.addWorker(beginner);
        updateInventory(inventory);
    }

    public void processRemoveWorker(Inventory inventory,
                            FarmWorker worker) {
        inventory.removeWorker(worker);
        updateInventory(inventory);
    }

    /*public void processExpertAdd(Inventory inventory) {
        inventory.addExpert();
        updateInventory(inventory);
    }

    public void processExpertRemove(Inventory inventory, ExpertWorker expertWorker) {
        inventory.removeExpert(expertWorker);
        updateInventory(inventory);
    }*/

    public void processTractorAdd(Inventory inventory) {
        inventory.addTractor();
        updateInventory(inventory);
    }

    public void processIrrigtionAdd(Inventory inventory) {
        inventory.addIrrigation();
        updateInventory(inventory);
    }

    public void updateInventory(Inventory inventory) {
        inventoryHBox.getChildren().clear();
        Set<Map.Entry<Crop, Integer>> cropSet = inventory.getCropMap().entrySet();
        for (Map.Entry<Crop, Integer> cropEntry : cropSet) {
            Crop crop = cropEntry.getKey();
            int quantity = cropEntry.getValue();
            if (quantity > 0) {
                Shape icon = crop.getIcon();
                Label name = new Label(crop.getType() + " (x" + quantity + ")");
                VBox cropDisplay = new VBox(20);
                cropDisplay.setAlignment(Pos.CENTER);
                cropDisplay.getChildren().addAll(icon, name);
                inventoryHBox.getChildren().add(cropDisplay);
            }
        }

        Set<Map.Entry<Seed, Integer>> seedSet = inventory.getSeedMap().entrySet();
        for (Map.Entry<Seed, Integer> seedEntry : seedSet) {
            Seed seed = seedEntry.getKey();
            int quantity = seedEntry.getValue();
            if (quantity > 0) {
                Shape icon = seed.getIcon();
                Label name = new Label(seed.getType() + " (x" + quantity + ")");
                VBox seedDisplay = new VBox(20);
                seedDisplay.setAlignment(Pos.CENTER);
                seedDisplay.getChildren().addAll(icon, name);
                inventoryHBox.getChildren().add(seedDisplay);
            }
        }

        if (inventory.getFertilizerAmount() > 0) {
            Shape icon = new Rectangle(40, 80);
            icon.setStyle("-fx-fill: darkseagreen; -fx-stroke: forestgreen; "
                    + "-fx-stroke-width: 5");
            Label name = new Label("Fertilizer (x" + inventory.getFertilizerAmount() + ")");
            VBox fertilizerDisplay = new VBox(20);
            fertilizerDisplay.setAlignment(Pos.CENTER);
            fertilizerDisplay.getChildren().addAll(icon, name);
            inventoryHBox.getChildren().add(fertilizerDisplay);
        }

        if (inventory.getPesticideAmount() > 0) {
            Shape icon = new Rectangle(40, 80);
            icon.setStyle("-fx-fill: papayawhip; -fx-stroke: palegoldenrod; "
                    + "-fx-stroke-width: 5");
            Label name = new Label("Pesticide (x" + inventory.getPesticideAmount() + ")");
            VBox pesticideDisplay = new VBox(20);
            pesticideDisplay.setAlignment(Pos.CENTER);
            pesticideDisplay.getChildren().addAll(icon, name);
            inventoryHBox.getChildren().add(pesticideDisplay);
        }

        if (inventory.getBeginnerAmount() > 0) {
            Shape icon = new Ellipse(40, 20);
            icon.setStyle("-fx-fill: lightsalmon; -fx-stroke: coral; " + "-fx-stroke-width: 5");
            Label name =
                    new Label("Beginner Worker (x" + inventory.getBeginnerAmount() + ")");
            int totalPlotsLeft = 0;
            for (FarmWorker worker : inventory.getWorkers()) {
                if (worker instanceof BeginnerWorker) {
                    totalPlotsLeft += worker.getPlotsLeft();
                }
            }
            Label plotsLeft = new Label("(" + totalPlotsLeft + " plots left to"
                    + " harvest)");
            VBox beginnerDisplay = new VBox(20);
            beginnerDisplay.setAlignment(Pos.CENTER);
            beginnerDisplay.getChildren().addAll(icon, name, plotsLeft);
            inventoryHBox.getChildren().add(beginnerDisplay);
        }

        if (inventory.getExpertAmount() > 0) {
            Shape icon = new Ellipse(40, 20);
            icon.setStyle("-fx-fill: lightpink; -fx-stroke: palevioletred; "
                    + "-fx-stroke-width: 5");
            Label name =
                    new Label("Expert Worker (x" + inventory.getExpertAmount() + ")");
            int totalPlotsLeft = 0;
            for (FarmWorker worker : inventory.getWorkers()) {
                if (worker instanceof ExpertWorker) {
                    totalPlotsLeft += worker.getPlotsLeft();
                }
            }
            Label plotsLeft = new Label("(" + totalPlotsLeft + " plots left to"
                    + " harvest)");
            VBox expertDisplay = new VBox(20);
            expertDisplay.setAlignment(Pos.CENTER);
            expertDisplay.getChildren().addAll(icon, name, plotsLeft);
            inventoryHBox.getChildren().add(expertDisplay);
        }
        if (inventory.isTractor()) {
            Shape icon = new Rectangle(80, 40);
            icon.setStyle("-fx-fill: hotpink; -fx-stroke: deeppink; "
                    + "-fx-stroke-width: 5");
            Label name = new Label("Tractor");
            VBox tractorDisplay = new VBox(20);
            tractorDisplay.setAlignment(Pos.CENTER);
            tractorDisplay.getChildren().addAll(icon, name);
            inventoryHBox.getChildren().add(tractorDisplay);
        }
        if (inventory.isIrrigation()) {
            Shape icon = new Rectangle(80, 40);
            icon.setStyle("-fx-fill: aquamarine; -fx-stroke: aqua; "
                    + "-fx-stroke-width: 5");
            Label name = new Label("Irrigation");
            VBox irrigationDisplay = new VBox(20);
            irrigationDisplay.setAlignment(Pos.CENTER);
            irrigationDisplay.getChildren().addAll(icon, name);
            inventoryHBox.getChildren().add(irrigationDisplay);
        }

    }

    public ScrollPane getInventoryTab() {
        return inventoryTab;
    }

    public HBox getInventoryHBox() {
        return inventoryHBox;
    }
}
