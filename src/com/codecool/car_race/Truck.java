package com.codecool.car_race;

import java.util.Random;

public class Truck extends Vehicle {

    private int breakdownTurnsLeft=0;
    private int probability;
    private boolean isBroken = false;

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public Truck() {
        Random randomTruckNumber = new Random();
        int truckName = randomTruckNumber.nextInt(1000);
        setName(String.format("%s", truckName));
        setBroken(false);
    }
    @Override
    public void prepareForLap(Race race) {
        Random random = new Random();
        probability = random.nextInt(100);

        if (probability < 5) {
            setBroken(true);
        }
        setSpeed(100);
    }

    @Override
    public void prepareForLap(Race race, int reducedSpeed) {
        setSpeed(reducedSpeed);
    }
}
