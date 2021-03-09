package main;

import crop.*;

import javafx.scene.layout.VBox;
import ui.FarmScreen;
import ui.InventoryTab;
import ui.KowhsFarmUIController;

public class Market {

    private GamePlay game;

    public Market(GamePlay game) {
        this.game = game;
    }

    public void buySeed(Inventory inventory, Seed seed, InventoryTab inventoryTab) {

        if (inventory.getSize() < inventory.getInventoryCapacity() && game.getMoney()
                >= seedPrice(seed)) {
            inventoryTab.processAddSeed(game.getInventory(), seed);
            game.setMoney(game.getMoney() - seedPrice(seed));
            FarmScreen farmScreen = KowhsFarmUIController.getFarmScreen();
            farmScreen.updateTitle(game, farmScreen.getTitles(), farmScreen.getButtonHbox());
        }
    }

    public void sellCrop(Inventory inventory, Crop crop, InventoryTab inventoryTab) {

        if (inventory.getCropMap().get(crop) > 0) {
            if (crop.getNumWithPesticide() > 0) {
                game.setMoney(game.getMoney() + (int) (cropPrice(crop) * .5));
                crop.removeWithPesticide();
            } else {
                game.setMoney(game.getMoney() + cropPrice(crop));
            }
            inventoryTab.processCropRemove(inventory, crop);
            FarmScreen farmScreen = KowhsFarmUIController.getFarmScreen();
            farmScreen.updateTitle(game, farmScreen.getTitles(), farmScreen.getButtonHbox());
        }
    }

    public int cropPrice(Crop crop) {
        if (game.getDifficulty().equals("Easy")) {
            return crop.getBasePrice() * 2;
        } else if (game.getDifficulty().equals("Medium")) {
            return (int) (crop.getBasePrice() * 1.5);
        } else {
            return crop.getBasePrice();
        }
    }

    public int seedPrice(Seed seed) {
        if (game.getDifficulty().equals("Easy")) {
            return seed.getBasePrice();
        } else if (game.getDifficulty().equals("Medium")) {
            return seed.getBasePrice() * 2;
        }
        return seed.getBasePrice() * 3;
    }

    public void buyFertilizer(Inventory inventory, InventoryTab inventoryTab) {
        if (inventory.getSize() < inventory.getInventoryCapacity()
                && game.getMoney() >= fertilizerPrice()) {
            inventoryTab.processFertilizerAdd(game.getInventory());
            game.setMoney(game.getMoney() - fertilizerPrice());
            FarmScreen farmScreen = KowhsFarmUIController.getFarmScreen();
            farmScreen.updateTitle(game, farmScreen.getTitles(), farmScreen.getButtonHbox());
        }
    }

    public int fertilizerPrice() {
        if (game.getDifficulty().equals("Easy")) {
            return 10;
        } else if (game.getDifficulty().equals("Medium")) {
            return 25;
        }
        return 50;
    }

    public void buyPesticide(Inventory inventory, InventoryTab inventoryTab) {
        if (inventory.getSize() < inventory.getInventoryCapacity()
                && game.getMoney() >= pesticidePrice()) {
            inventoryTab.processPesticideAdd(game.getInventory());
            game.setMoney(game.getMoney() - pesticidePrice());
            FarmScreen farmScreen = KowhsFarmUIController.getFarmScreen();
            farmScreen.updateTitle(game, farmScreen.getTitles(), farmScreen.getButtonHbox());

        }
    }

    public int pesticidePrice() {
        if (game.getDifficulty().equals("Easy")) {
            return 10;
        } else if (game.getDifficulty().equals("Medium")) {
            return 25;
        } else {
            return 50;
        }
    }


    public int beginnerWage() {
        if (game.getDifficulty().equals("Easy")) {
            return 50;
        } else if (game.getDifficulty().equals("Medium")) {
            return 60;
        } else {
            return 70;
        }
    }

    public int expertWage() {
        if (game.getDifficulty().equals("Easy")) {
            return 70;
        } else if (game.getDifficulty().equals("Medium")) {
            return 85;
        } else {
            return 90;
        }
    }

    public void hireBeginner(Inventory inventory, InventoryTab tab) {
        if (inventory.getSize() < inventory.getInventoryCapacity()
                && game.getMoney() >= beginnerWage()) {
            tab.processAddWorker(game.getInventory(), true);
            game.setMoney(game.getMoney() - beginnerWage());
            FarmScreen farmScreen = KowhsFarmUIController.getFarmScreen();
            farmScreen.updateTitle(game, farmScreen.getTitles(), farmScreen.getButtonHbox());
        }
    }

    public void hireExpert(Inventory inventory, InventoryTab tab) {
        if (game.getMoney() >= expertWage()) {
            tab.processAddWorker(game.getInventory(), false);
            game.setMoney(game.getMoney() - expertWage());
            FarmScreen farmScreen = KowhsFarmUIController.getFarmScreen();
            farmScreen.updateTitle(game, farmScreen.getTitles(), farmScreen.getButtonHbox());
        }
    }

    public void buyTractor(Inventory inventory, InventoryTab inventoryTab) {
        if (inventory.getSize() < inventory.getInventoryCapacity()
                && game.getMoney() >= 20 && !inventory.isTractor()) {
            inventoryTab.processTractorAdd(game.getInventory());
            game.setMoney(game.getMoney() - 20);
            game.setMaxHarvestable(10);
            FarmScreen farmScreen = KowhsFarmUIController.getFarmScreen();
            farmScreen.updateTitle(game, farmScreen.getTitles(), farmScreen.getButtonHbox());
        }
    }
    public void buyIrrigation(Inventory inventory, InventoryTab inventoryTab) {
        if (inventory.getSize() < inventory.getInventoryCapacity()
                && game.getMoney() >= 20 && !inventory.isIrrigation()) {
            inventoryTab.processIrrigtionAdd(game.getInventory());
            game.setMoney(game.getMoney() - 20);
            game.setMaxWaterable(10);
            FarmScreen farmScreen = KowhsFarmUIController.getFarmScreen();
            farmScreen.updateTitle(game, farmScreen.getTitles(), farmScreen.getButtonHbox());
        }
    }

    public void buyPlot(InventoryTab inventoryTab) {
        if (game.getMoney() >= plotPrice() && game.getPlotArray().size() < 10) {
            game.setMoney(game.getMoney() - plotPrice());
            FarmScreen farmScreen = KowhsFarmUIController.getFarmScreen();
            farmScreen.createPlot(farmScreen.getMiddle(),
                    game.getPlotArray().size() + 1,
                    (VBox) farmScreen.getRoot().getRight());
            farmScreen.updateTitle(game, farmScreen.getTitles(), farmScreen.getButtonHbox());
        }
    }

    public int plotPrice() {
        if (game.getDifficulty().equals("Easy")) {
            return game.getPlotArray().size() * 10;
        } else if (game.getDifficulty().equals("Medium")) {
            return game.getPlotArray().size() * 15;
        } else {
            return game.getPlotArray().size() * 20;
        }
    }
}


