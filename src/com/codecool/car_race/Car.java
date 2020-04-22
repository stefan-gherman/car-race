package com.codecool.car_race;

import java.util.Random;

public class Car extends Vehicle {

    String[] possibleNamesList = new String[] {"Gallop", "Albatross", "Alabaster", "Viper", "Excursion", "Scorpion", "Encounter", "Blend", "Umbra", "Motive",
            "Bison", "Renaissance", "Vision", "Empyrée", "Magie", "Orbite", "Souhait", "Halo", "Formule", "Chasseur"
    };
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
        setSpeed(randomSpeed.nextInt((110-80)+1)+80);
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
        setSpeed(randomSpeed.nextInt((75-25)+1)+25);
    }




}
