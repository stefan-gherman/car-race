package com.codecool.car_race;

import java.util.Random;

public class Motorcycle extends Vehicle {


    public Motorcycle(int motorcycleNumber) {
        setName("Motorcycle " + motorcycleNumber);
    }

    @Override
    public void prepareForLap(Race race) {
        setSpeed(100);
    }

    @Override
    public void prepareForLap(Race race, int reducedSpeed) {
        setSpeed(reducedSpeed);
    }
}
