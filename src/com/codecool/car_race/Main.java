package com.codecool.car_race;


import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * Creates all the vehicles that will be part of this race.
     */
    private static void createVehicles(Race race) {

        for (int i=0; i<10; i++) {
            race.registerRacer(new Car());
            race.registerRacer(new Truck());
            race.registerRacer(new Motorcycle(i+1));
        }
    }

    /**
     * Entry point of our program. Creates one race instance and
     * uses that.
     * <p>
     *
     * @param args commandline arguments passed to the program.
     *             It is unused.
     */
    public static void main(String[] args) {
        Race race = new Race();
        createVehicles(race);


        race.simulateRace();
//        race.printRaceResults();


    }
}
