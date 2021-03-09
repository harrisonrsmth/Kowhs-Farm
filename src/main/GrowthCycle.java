package main;

public class GrowthCycle {

    private String currentCycle;
    public static final String EMPTY = "Empty";
    public static final String SEED = "Seed (0/5)";
    public static final String IMMATURE1 = "Immature (1/5)";
    public static final String IMMATURE2 = "Immature (2/5)";
    public static final String IMMATURE3 = "Immature (3/5)";
    public static final String IMMATURE4 = "Immature (4/5)";
    public static final String MATURE = "Mature (5/5)";
    public static final String DEAD = "Dead";

    public GrowthCycle() {
        currentCycle = EMPTY;
    }

    public void grow() {
        switch (currentCycle) {
        case SEED:      currentCycle = IMMATURE1;
                        break;
        case IMMATURE1: currentCycle = IMMATURE2;
                        break;
        case IMMATURE2: currentCycle = IMMATURE3;
                        break;
        case IMMATURE3: currentCycle = IMMATURE4;
                        break;
        case IMMATURE4: currentCycle = MATURE;
                        break;
        default:        break;
        }
    }

    public String getCurrentCycle() {
        return currentCycle;
    }

    public void setCurrentCycle(String currentCycle) {
        this.currentCycle = currentCycle;
    }
}
