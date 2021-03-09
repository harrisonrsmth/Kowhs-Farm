package main;

import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.Random;


public class RandomEvents {

    private Random rand;
    private int locustDamage;
    private GamePlay game;
    private String[] eventTypes = {"rain", "drought", "locust"};
    private int eventOccurrenceProbability;
    private Alert alert;
    private ArrayList<Plot> plots;
    private int droughtLevel;
    private int rainLevel;



    public RandomEvents(GamePlay game) {
        this.game = game;
        this.plots = game.getPlotArray();
        this.rand = new Random();
        alert = new Alert(Alert.AlertType.WARNING);
        alert.setX(660);
        alert.setY(285);
    }

    public void wreakHavoc() {
        if (game.getDay() == 7) {
            eventOccurrenceProbability = 2;
        } else if (game.getDay() == 8) {
            eventOccurrenceProbability = 0;
        } else if (game.getDay() == 9) {
            eventOccurrenceProbability = 1;
        } else {
            return;
        }

        /*if (this.game.getDifficulty().equals("Easy")) {
            eventOccurrenceProbability = rand.nextInt(10);
        } else if (this.game.getDifficulty().equals("Medium")) {
            eventOccurrenceProbability = rand.nextInt(8);
        } else if (this.game.getDifficulty().equals("Hard")) {
            eventOccurrenceProbability = rand.nextInt(5);
        }*/

        if (eventOccurrenceProbability < 3) {
            String event = eventTypes[eventOccurrenceProbability];
            if (event.equals("rain")) {
                rain();
                alert.setTitle("Rain!");
                alert.setHeaderText("Rain!");
                alert.setContentText("A heavy rain has occurred, water levels increased by "
                        + rainLevel + ".");
                alert.show();
            } else if (event.equals("drought")) {
                drought();
                alert.setTitle("Drought!");
                alert.setHeaderText("Drought!");
                alert.setContentText("A drought has occurred, water levels "
                        + "have decreased by\nan additional " + droughtLevel + " level(s).");
                alert.show();
            } else if (event.equals("locust")) {
                locusts();
                alert.setTitle("Locusts!");
                alert.setHeaderText("Locusts!");
                alert.setContentText("Locusts attacked, " + locustDamage
                        + " plots with crops were affected.");
                alert.show();
            }
        }
    }

    private void rain() {
        rainLevel =  rand.nextInt(3) + 1;
        for (Plot plot : plots) {
            if (!plot.getGrowthCycle().getCurrentCycle().equals(GrowthCycle.EMPTY)
                && !plot.getGrowthCycle().getCurrentCycle().equals(GrowthCycle.DEAD)) {
                int rainEffect = plot.getWaterLevel() + rainLevel + 1;
                plot.setWaterLevel(rainEffect);
                if (plot.getWaterLevel() > 4) {
                    plot.getGrowthCycle().setCurrentCycle(GrowthCycle.DEAD);
                    plot.setText(plot.getCropType().getType() + ": "
                            + plot.getGrowthCycle().getCurrentCycle());
                    continue;
                }
                plot.setText(plot.getUpdateText());
            }
        }
    }

    private void drought() {
        droughtLevel = rand.nextInt(2) + 1;
        for (Plot plot : plots) {
            if (!plot.getGrowthCycle().getCurrentCycle().equals(GrowthCycle.EMPTY)
                    && !plot.getGrowthCycle().getCurrentCycle().equals(GrowthCycle.DEAD)) {
                int droughtEffect = plot.getWaterLevel() - droughtLevel;
                plot.setWaterLevel(droughtEffect);
                if (plot.getWaterLevel() < 0) {
                    plot.getGrowthCycle().setCurrentCycle(GrowthCycle.DEAD);
                    plot.setText(plot.getCropType().getType() + ": "
                            + plot.getGrowthCycle().getCurrentCycle());
                    continue;
                }
                plot.setText(plot.getUpdateText());
            }
        }
    }

    public void locusts() {
        locustDamage = 0;
        if (this.game.getDifficulty().equals("Easy")) {
            int count = 0;
            while (count < 2) {
                swarm();
                count++;
            }

        } else if (this.game.getDifficulty().equals("Medium")) {
            int count = 0;

            while (count < 4) {
                swarm();
                count++;
            }

        } else if (this.game.getDifficulty().equals("Hard")) {
            int count = 0;
            while (count < 6) {
                swarm();
                count++;
            }
        }
    }

    private void swarm() {
        int locustsLevel = rand.nextInt(game.getPlotArray().size());
        if (!plots.get(locustsLevel).getGrowthCycle().getCurrentCycle().equals(GrowthCycle.EMPTY)
                && (!plots.get(locustsLevel).getHasPesticide())
                && !plots.get(locustsLevel).getGrowthCycle().getCurrentCycle()
                .equals(GrowthCycle.DEAD)) {
            locustDamage++;
            plots.get(locustsLevel).getGrowthCycle().setCurrentCycle(GrowthCycle.DEAD);
            plots.get(locustsLevel).setText(plots.get(locustsLevel).getCropType().getType()
                    + ": " + plots.get(locustsLevel).getGrowthCycle().getCurrentCycle());
        }
    }
}
