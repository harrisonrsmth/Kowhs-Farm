package main;

import crop.Crop;
import crop.Seed;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

import ui.FarmScreen;
import ui.InventoryTab;
import ui.KowhsFarmUIController;

public class Plot extends MenuButton {

    private Seed seedType;
    private Crop cropType;
    private MenuItem harvest = new MenuItem("Harvest");
    private MenuItem plant = new MenuItem("Plant");
    private MenuItem water = new MenuItem("Water");
    private MenuItem fertilize = new MenuItem("Fertilize");
    private MenuItem pesticide = new MenuItem("Spray Pesticide");
    private Inventory inventory;
    private InventoryTab inventoryTab;
    private GrowthCycle growthCycle;
    private GamePlay game;
    private Alert alert;
    private int fertilizerLevel;
    private boolean hasPesticide;
    private static final int MAX_FERTILIZER_LEVEL = 5;
    public static final int MAX_WATER_LEVEL = 3;
    private int waterLevel;




    public Plot(Inventory inventory, InventoryTab inventoryTab, GamePlay game) {
        super();
        growthCycle = new GrowthCycle();
        this.setText(growthCycle.getCurrentCycle());
        this.inventory = inventory;
        this.inventoryTab = inventoryTab;
        this.game = game;
        this.getItems().addAll(harvest, plant, water, fertilize, pesticide);
        this.setPrefSize(175, 175);
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setX(660);
        alert.setY(285);
    }

    public void harvest(boolean withFarmer) {
        if (game.getPlotsHarvested() < game.getMaxHarvestable()) {
            if (growthCycle.getCurrentCycle().equals(GrowthCycle.MATURE)
                    && inventory.getSize() < inventory.getInventoryCapacity()) {
                growthCycle.setCurrentCycle(GrowthCycle.EMPTY);
                if (fertilizerLevel > 0) {
                    if (((int) (Math.random() * 9)) >= 5) {
                        inventoryTab.processCropAdd(inventory, cropType);
                    }
                }
                if (hasPesticide) {
                    cropType.addWithPesticide();
                }
                inventoryTab.processCropAdd(inventory, cropType);
                this.setText(growthCycle.getCurrentCycle());
                if (cropType.getType().equals("Corn")) {
                    game.addCorn();
                } else if (cropType.getType().equals("Rice")) {
                    game.addRice();
                } else {
                    game.addWheat();
                }
                if (!withFarmer) {
                    game.increasePlotsHarvested();
                }
            }
        } else {
            alert.setTitle("Can't Harvest!");
            alert.setHeaderText("Can't Harvest!");
            alert.setContentText("You have harvested your max number of plots for the day. "
                    + "Buy a tractor to increase the plots you can harvest in a single day.");
            alert.show();
        }
        FarmScreen farmScreen = KowhsFarmUIController.getFarmScreen();
        farmScreen.updateTitle(game, farmScreen.getTitles(), farmScreen.getButtonHbox());
        game.win();
    }

    public void plant(Seed seed) {
        if (seed != null && (growthCycle.getCurrentCycle().equals(GrowthCycle.EMPTY)
                || growthCycle.getCurrentCycle().equals(GrowthCycle.DEAD))
                && inventory.getSeedMap().get(seed) > 0) {
            this.seedType = seed;
            int i = 0;
            while (i < Crop.getCropsLength()) { //compare seed and crop arrays to get the crop type
                if (Crop.getCrops()[i].getType().equals(seedType.getCropType())) {
                    cropType = Crop.getCrops()[i];
                    break;
                }
                i++;
            }
            inventoryTab.processRemoveSeed(inventory, seed);
            growthCycle.setCurrentCycle(GrowthCycle.SEED);
            waterLevel = 0;
            hasPesticide = false;
            fertilizerLevel = 0;
            this.setText(getUpdateText());
        }
    }

    public void water() {
        if (game.getPlotsWatered() < game.getMaxWaterable()) {
            if (!growthCycle.getCurrentCycle().equals(GrowthCycle.DEAD)
                    && !growthCycle.getCurrentCycle().equals(GrowthCycle.EMPTY)) {
                waterLevel++;
                if (waterLevel > MAX_WATER_LEVEL) {
                    growthCycle.setCurrentCycle(GrowthCycle.DEAD);
                    this.setText(cropType.getType() + ": " + growthCycle.getCurrentCycle());
                } else {
                    this.setText(getUpdateText());
                }
            }
            game.increasePlotsWatered();
        } else {
            alert.setTitle("Can't Water!");
            alert.setHeaderText("Can't Water!");
            alert.setContentText("You have watered your max number of plots for the day. " +
                    "Buy irrigation to increase the plots you can water in a single day.");
            alert.show();
        }
    }

    public void fertilize() {
        if (!growthCycle.getCurrentCycle().equals(GrowthCycle.DEAD)
                && !growthCycle.getCurrentCycle().equals(GrowthCycle.EMPTY)
                && fertilizerLevel < MAX_FERTILIZER_LEVEL
                && inventory.getFertilizerAmount() > 0) {
            fertilizerLevel++;
            inventoryTab.processFertilizerRemove(inventory);
            this.setText(getUpdateText());
        }
    }

    public void sprayPesticide() {
        if (!growthCycle.getCurrentCycle().equals(GrowthCycle.DEAD)
                && !growthCycle.getCurrentCycle().equals(GrowthCycle.EMPTY)
                && inventory.getPesticideAmount() > 0 && !hasPesticide) {
            inventoryTab.processPesticideRemove(inventory);
            hasPesticide = true;
            this.setText(getUpdateText());
        }
    }

    public void grow() {
        if (!growthCycle.getCurrentCycle().equals(GrowthCycle.DEAD)
                && !growthCycle.getCurrentCycle().equals(GrowthCycle.EMPTY)) {
            waterLevel--;
            if (waterLevel >= 0) {
                if (fertilizerLevel > 0) {
                    growthCycle.grow();
                    fertilizerLevel--;
                }
                growthCycle.grow();
            } else {
                growthCycle.setCurrentCycle(GrowthCycle.DEAD);
            }

            if (!growthCycle.getCurrentCycle().equals(GrowthCycle.EMPTY)
                && !growthCycle.getCurrentCycle().equals(GrowthCycle.DEAD)) {
                this.setText(getUpdateText());
            } else if (growthCycle.getCurrentCycle().equals(GrowthCycle.DEAD)) {
                this.setText(cropType.getType() + ": " + growthCycle.getCurrentCycle());
            } else {
                this.setText(GrowthCycle.EMPTY);
            }
        } else {
            fertilizerLevel--;
        }
    }

    public MenuItem getHarvest() {
        return harvest;
    }
    public MenuItem getPlant() {
        return plant;
    }
    public MenuItem getWater() {
        return water;
    }
    public MenuItem getFertilize() {
        return fertilize;
    }

    public MenuItem getPesticide() {
        return pesticide;
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(int waterLevel) {
        this.waterLevel = waterLevel;
    }

    public int getFertilizerLevel() {
        return fertilizerLevel;
    }

    public boolean getHasPesticide() {
        return hasPesticide;
    }

    public Seed getSeedType() {
        return seedType;
    }

    public Crop getCropType() {
        return cropType;
    }

    public GrowthCycle getGrowthCycle() {
        return growthCycle;
    }

    public String getUpdateText() {
        return cropType.getType() + ": " + growthCycle.getCurrentCycle() + "\nWater: "
                + waterLevel + "/" + WaterLevel.MAX_WATER_LEVEL + "\nFertilizer: "
                + fertilizerLevel + "/" + MAX_FERTILIZER_LEVEL + "\nPesticide: " + hasPesticide;
    }

    /*public String getRandomState() {
        String[] arr = {"Empty", seedType.getCropType() + ": Seed",
                seedType.getCropType() + ": Immature", seedType.getCropType() + ": Mature"};
        return arr[(int) (Math.random() * 4)];
    }*/
}
