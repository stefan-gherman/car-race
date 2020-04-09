package com.codecool.car_race;


import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * Creates all the vehicles that will be part of this race.
     */
    private static void createVehicles(Race race) {
        List<Car> carList = new ArrayList<Car>();
        for (int i = 0; i<10; i++) {
            carList.add(new Car());
        }

        for (Car car: carList) {
            System.out.println(car.toString());

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

        //race.simulateRace();
        //race.printRaceResults();


    }
}
