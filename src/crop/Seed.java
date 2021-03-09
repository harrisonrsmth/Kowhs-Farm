package crop;

import javafx.scene.shape.Shape;

public abstract class Seed {
    protected int basePrice;
    protected String type;
    protected Shape icon;
    protected String cropType;
    //Be sure to use this array to index into when adding or removing seeds.
    // If not, since equality is reference based, the add and remove methods
    // will give a null pointer exception because a new instance won't be in
    // the map and it will get angry. Same goes for crops.
    private static Seed[] seeds = {new CornSeed(), new WheatSeed(), new RiceSeed()};

    public String getType() {
        return type;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public Shape getIcon() {
        return icon;
    }

    public static Seed[] getSeeds() {
        return seeds;
    }

    public String getCropType() {
        return cropType;
    }
}