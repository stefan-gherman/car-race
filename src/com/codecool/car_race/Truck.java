package com.codecool.car_race;

import java.util.Random;

public class Truck extends Vehicle {

    private int breakdownTurnsLeft=0;
    private int probability;
    private boolean isBroken = false;
    private final int MAX_TRUCK_SPEED = 100;
    private final int MIN_TRUCK_SPEED = 0;

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
    public void prepareForLap() {
        Random random = new Random();
        probability = random.nextInt(100);

        if (probability < 5 && !isBroken()) {
            setBroken(true);
            breakdownTurnsLeft = 2;
            setSpeed(MIN_TRUCK_SPEED);
        } else if (isBroken()) {
            breakdownTurnsLeft -= 1;
            if (breakdownTurnsLeft <= 0) {
                breakdownTurnsLeft = 0;
                setBroken(false);
                setSpeed(MAX_TRUCK_SPEED);
            }
        }


    }



    @Override
    public void prepareForLap(int reducedSpeed) {
        setSpeed(reducedSpeed);
    }

    @Override
    public void moveForAnHour() {
        this.setDistanceTraveled(this.getDistanceTraveled() + this.getSpeed());
    }

    @Override
    public void prepareForLapTruckDown() {
        prepareForLap();
    }

    @Override
    public void prepareForLapRain() {
        prepareForLap();

    }

    public String toString() {
        return String.format("%s speed: %s distance: %s broken: %s type: %s", this.getName(), this.getSpeed(), this.getDistanceTraveled(), this.isBroken(), this.getClass().toString().substring(28));
    }
}
