package main;

import crop.Seed;
import ui.KowhsFarmUIController;

import java.util.ArrayList;

public class GamePlay {
    private int money;
    private int day;
    private String name;
    private String season;
    private Seed startingSeed;
    private String difficulty;
    private Inventory inventory;
    private Plot plot;
    private int plotsHarvested;
    private int plotsWatered;
    private int maxHarvestable = 2;
    private int maxWaterable = 3;
    private int plotsOwned;
    private ArrayList<Plot> plotArray;
    private int cornCount;
    private int riceCount;
    private int wheatCount;


    public GamePlay() {
        money = 100;
        day = 1;
        name = null;
        season = "Spring";
        startingSeed = Seed.getSeeds()[0];
        difficulty = "Easy";
        inventory = new Inventory(startingSeed);
        plotArray = new ArrayList<>();
    }

    public void addCorn() {
        cornCount++;
    }

    public void addRice() {
        riceCount++;
    }

    public void addWheat() {
        wheatCount++;
    }


    public void win() {
        if (cornCount >= 3 && riceCount >= 3 && wheatCount >= 3) {
            KowhsFarmUIController.winScreen();
        }
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Seed getStartingSeed() {
        return startingSeed;
    }

    public void setStartingSeed(Seed startingSeed) {
        this.startingSeed = startingSeed;
        inventory = new Inventory(startingSeed);
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty, int money) {
        this.difficulty = difficulty;
        this.money = money;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getPlotsHarvested() {
        return plotsHarvested;
    }

    public int getPlotsWatered() {
        return plotsWatered;
    }

    public void setPlotsHarvested(int plotsHarvested) {
        this.plotsHarvested = plotsHarvested;
    }

    public void setPlotsWatered(int plotsWatered) {
        this.plotsWatered = plotsWatered;
    }

    public void setMaxHarvestable(int n) {
        maxHarvestable = n;
    }

    public void setMaxWaterable(int n) {
        maxWaterable = n;
    }

    public int getMaxHarvestable() {
        return maxHarvestable;
    }

    public int getMaxWaterable() {
        return maxWaterable;
    }

    public void increasePlotsHarvested() {
        plotsHarvested++;
    }

    public void increasePlotsWatered() {
        plotsWatered++;
    }

    public ArrayList<Plot> getPlotArray() {
        return plotArray;
    }

    public int getCornCount() {
        return cornCount;
    }

    public int getRiceCount() {
        return riceCount;
    }

    public int getWheatCount() {
        return wheatCount;
    }
}
