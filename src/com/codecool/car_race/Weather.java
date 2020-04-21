package com.codecool.car_race;

import java.util.Random;

public class Weather {

    private boolean raining;

    public Weather() {
        this.raining = false;
    }

   public void setRaining() {
        Random rainChanceRandomize = new Random();

        int rainChance = rainChanceRandomize.nextInt(10);

        if(rainChance <= 2) {
            this.raining = true;
        } else {
            this.raining = false;
        }

    }

   public boolean isRaining() {
        return  this.raining;
    }
}
