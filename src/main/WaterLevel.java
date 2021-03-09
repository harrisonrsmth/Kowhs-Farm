package main;

public class WaterLevel {
    public static final int MAX_WATER_LEVEL = 3;
    private int waterLevel;
    private Plot plot;

    public WaterLevel() {
        waterLevel = 1;
    }

    public void water() {
        waterLevel++;
    }

    public void proceedDay() {
        waterLevel--;
    }

    public void setWaterLevel(Integer waterLevel) {
        this.waterLevel = waterLevel;
    }

    public int getWaterLevel() {
        return waterLevel;
    }
}
