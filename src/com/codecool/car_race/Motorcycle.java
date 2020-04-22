package com.codecool.car_race;

import java.util.Random;

public class Motorcycle extends Vehicle {

    private final int MOTORCYCLE_MAX_SPEED_UNDER_NORMAL_CONDITIONS = 100;


    public Motorcycle(int motorcycleNumber) {
        setName("Motorcycle " + motorcycleNumber);
    }

    @Override
    public void moveForAnHour() {
        this.setDistanceTraveled(this.getDistanceTraveled() + this.getSpeed());
    }

    @Override
    public void prepareForLap() {
        setSpeed(100);
    }

    @Override
    public void prepareForLap(int reducedSpeed) {

    }

    @Override
    public void prepareForLapRain() {
        Random random = new Random();
        int reducedSpeed = random.nextInt((50-5)+1) +5;
        setSpeed(100-reducedSpeed);
    }

    @Override
    public void prepareForLapTruckDown() {

    }
}
