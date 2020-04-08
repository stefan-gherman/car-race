package com.codecool.car_race;

import java.util.Random;

public abstract class Weather {

    private static boolean raining = false;

    static void setRaining() {
        Random rainChanceRandomize = new Random();

        int rainChance = rainChanceRandomize.nextInt(9);

        if(rainChance <= 2) {
            raining = true;
        } else {
            raining = false;
        }

    }

    static boolean isRaining() {
        return  raining;
    }
}
