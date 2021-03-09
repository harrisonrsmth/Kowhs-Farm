package crop;

import javafx.scene.shape.Shape;

public abstract class Crop {
    protected int basePrice;
    protected String type;
    protected String growthStage;
    protected Shape icon;
    protected int numWithPesticide;
    //Be sure to use this array to index into when adding or removing crops.
    // If not, since equality is reference based, the add and remove methods
    // will give a null pointer exception because a new instance won't be in
    // the map and it will get angry. Same goes for seeds.
    private static Crop[] crops = {new Corn(), new Wheat(), new Rice()};

    public String getType() {
        return type;
    }

    public String getGrowthStage() {
        return growthStage;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public Shape getIcon() {
        return icon;
    }

    public void setGrowthStage(String stage) {
        this.growthStage = growthStage;
    }

    public static Crop[] getCrops() {
        return crops;
    }

    public static int getCropsLength() {
        return crops.length;
    }

    public int getNumWithPesticide() {
        return numWithPesticide;
    }

    public void addWithPesticide() {
        numWithPesticide++;
    }

    public void removeWithPesticide() {
        numWithPesticide--;
    }
}