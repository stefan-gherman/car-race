package com.codecool.car_race;

import java.util.Arrays;
import java.util.Random;

public class Car extends Vehicle {

    String[] possibleNamesList = new String[] {"Gallop", "Albatross", "Alabaster", "Viper", "Excursion", "Scorpion", "Encounter", "Blend", "Umbra", "Motive",
            "Bison", "Renaissance", "Vision", "Empyrée", "Magie", "Orbite", "Souhait", "Halo", "Formule", "Chasseur"
    };

    private final int MAX_SPEED_NO_TRUCK = 110;
    private final int MIN_SPEED_NO_TRUCK = 80;

    private final int MAX_SPEED_TRUCK = 75;
    private final int MIN_SPEED_TRUCK = 25;


    public Car() {
        String name1, name2;
        int index;
        Random randomIndex = new Random();
        index = randomIndex.nextInt(((19 - 0) + 1));
        name1 = possibleNamesList[index];

        if(index >= possibleNamesList.length/2) {
            index = randomIndex.nextInt(((9 - 0) + 1));
        } else {
            index = randomIndex.nextInt((19-11)+1) + 11;
        }
        name2 = possibleNamesList[index];
       setName(name1 + " " + name2);
    }

    @Override
    public void moveForAnHour() {
        this.setDistanceTraveled(this.getDistanceTraveled() + this.getSpeed());
    }

    @Override
    public void prepareForLap() {
        Random randomSpeed = new Random();
        setSpeed(randomSpeed.nextInt((MAX_SPEED_NO_TRUCK-MIN_SPEED_NO_TRUCK)+1)+MIN_SPEED_NO_TRUCK);
    }

    @Override
    public void prepareForLap(int reducedSpeed) {

    }

    @Override
    public void prepareForLapRain() {
        this.prepareForLap();
    }

    @Override
    public void prepareForLapTruckDown() {
        Random randomSpeed = new Random();
        setSpeed(randomSpeed.nextInt((MAX_SPEED_TRUCK-MIN_SPEED_TRUCK)+1)+MIN_SPEED_TRUCK);
    }

    @Override
    public String toString() {
        return String.format("%s speed: %s distance: %s type: Car", this.getName(), this.getSpeed(), this.getDistanceTraveled());
    }
}
