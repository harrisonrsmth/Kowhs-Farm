package main;

import crop.BeginnerWorker;
import crop.Crop;
import crop.ExpertWorker;
import crop.FarmWorker;
import crop.Seed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<Crop, Integer> cropMap;
    private Map<Seed, Integer> seedMap;
    private int size;
    private static final int CAPACITY = 10;
    private int fertilizerAmount;
    private int pesticideAmount;
    private boolean tractor;
    private boolean irrigation;
    //private ArrayList<BeginnerWorker> beginnerWorkers = new ArrayList<>();
    //private ArrayList<ExpertWorker> expertWorkers = new ArrayList<>();
    private ArrayList<FarmWorker> workers = new ArrayList<>();
    private int cropAmount;
    private int seedAmount;
    private int beginnerAmount;
    private int expertAmount;

    public Inventory(Seed startingSeed) {
        cropMap = new HashMap<>(10);
        for (Crop crop : Crop.getCrops()) {
            cropMap.put(crop, 0);
        }
        seedMap = new HashMap<>(10);
        for (Seed seed : Seed.getSeeds()) {
            seedMap.put(seed, 0);
        }
        size = 0;

        addSeed(startingSeed);
        addSeed(startingSeed);

        fertilizerAmount = 0;
        pesticideAmount = 0;
        tractor = false;
        irrigation = false;
        beginnerAmount = 0;
        expertAmount = 0;
    }

    public void addSeed(Seed seed) {
        if (size < CAPACITY) {
            int oldQuantity = seedMap.get(seed);
            seedMap.put(seed, oldQuantity + 1);
            size++;
            seedAmount++;
        }
    }

    public void addCrop(Crop crop) {
        if (size < CAPACITY) {
            cropMap.put(crop, cropMap.get(crop) + 1);
            size++;
            cropAmount++;
        }
    }

    public void removeSeed(Seed seed) {
        if (seedMap.get(seed) > 0) {
            seedMap.put(seed, seedMap.get(seed) - 1);
            size--;
            seedAmount--;
        }
    }

    public void removeCrop(Crop crop) {
        if (cropMap.get(crop) > 0) {
            cropMap.put(crop, cropMap.get(crop) - 1);
            size--;
            cropAmount--;
        }
    }

    public void addFertilizer() {
        if (size < CAPACITY) {
            fertilizerAmount++;
            size++;
        }
    }

    public void removeFertilizer() {
        fertilizerAmount--;
        size--;
    }

    public void addPesticide() {
        if (size < CAPACITY) {
            pesticideAmount++;
            size++;
        }
    }

    public void removePesticide() {
        pesticideAmount--;
        size--;
    }

    public Map<Crop, Integer> getCropMap() {
        return cropMap;
    }

    public Map<Seed, Integer> getSeedMap() {
        return seedMap;
    }

    public int getSize() {
        return size;
    }

    public int getInventoryCapacity() {
        return CAPACITY;
    }

    public int getFertilizerAmount() {
        return fertilizerAmount;
    }

    public int getPesticideAmount() {
        return pesticideAmount;
    }

    public void addWorker(boolean beginner) {
        if (size < CAPACITY) {
            if (beginner) {
                workers.add(new BeginnerWorker());
                beginnerAmount++;
            } else {
                workers.add(new ExpertWorker());
                expertAmount++;
            }
            size++;
        }
    }

    /*public void addExpert() {
        if (size < CAPACITY) {
            expertWorkers.add(new ExpertWorker());
            size++;
        }
    }*/

    public void removeWorker(FarmWorker worker) {
        workers.remove(worker);
        if (worker instanceof BeginnerWorker) {
            beginnerAmount--;
        } else {
            expertAmount--;
        }
        size--;
    }

    /*public void removeExpert(ExpertWorker expertWorker) {
        expertWorkers.remove(expertWorker);
        size--;
    }*/

    /*public ArrayList<BeginnerWorker> getBeginnerWorkers() {
        return beginnerWorkers;
    }

    public ArrayList<ExpertWorker> getExpertWorkers() {
        return expertWorkers;
    }*/

    public ArrayList<FarmWorker> getWorkers() {
        return workers;
    }

    public void addTractor() {
        if (size < CAPACITY) {
            tractor = true;
            size++;
        }
    }

    public void addIrrigation() {
        if (size < CAPACITY) {
            irrigation = true;
            size++;
        }
    }

    public boolean isTractor() {
        return tractor;
    }

    public boolean isIrrigation() {
        return irrigation;
    }

    public int getCropAmount() {
        return cropAmount;
    }

    public int getSeedAmount() {
        return seedAmount;
    }

    public int getBeginnerAmount() {
        return beginnerAmount;
    }

    public int getExpertAmount() {
        return expertAmount;
    }
}
