package crop;

import javafx.scene.shape.Shape;
import main.GamePlay;
import main.GrowthCycle;
import main.Inventory;
import main.Plot;
import ui.InventoryTab;
import ui.KowhsFarmUIController;

import java.util.ArrayList;

public class FarmWorker {
    protected int plotsLeft;
    protected Shape icon;

    public FarmWorker() { }

    public void work(GamePlay game, InventoryTab inventoryTab,
                     ArrayList<Integer> toDelete, int id) {
        int i = 0;
        while (plotsLeft > 0) {
            if (i < game.getPlotArray().size()) {
                Plot plot = game.getPlotArray().get(i);
                if (plot.getGrowthCycle().getCurrentCycle().equals(GrowthCycle.MATURE)) {
                    plot.harvest(true);
                    KowhsFarmUIController.getMarket().sellCrop(game.getInventory(),
                            plot.getCropType(), inventoryTab);
                    plotsLeft--;
                }
                i++;
            } else {
                break;
            }
        }
        if (plotsLeft == 0) {
            toDelete.add(id);
        }
    }

    public void deleteWorker(GamePlay game, InventoryTab inventoryTab) {
        inventoryTab.processRemoveWorker(game.getInventory(), this);
    }

    public int getPlotsLeft() {
        return plotsLeft;
    }

    public Shape getIcon() {
        return icon;
    }
}
