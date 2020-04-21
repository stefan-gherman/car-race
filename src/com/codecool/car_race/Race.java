package com.codecool.car_race;

import javax.sound.midi.Soundbank;
import javax.swing.table.TableRowSorter;
import java.util.*;

public class Race {

    String[] names = new String[]{"Le Mans", "Talladega", "Monza", "Spa Francorchamps", "Daytona 500"};
    String name;
    Weather raceWeather;

    private List<Vehicle> competitors = new ArrayList<Vehicle>();


    public Race() {
        Random random = new Random();
        this.name = names[random.nextInt(names.length)];
        raceWeather = new Weather();
    }

    public void registerRacer(Vehicle vehicle) {

        competitors.add(vehicle);
    }

    public void simulateRace() {
        Map<Float, Vehicle> standings = new TreeMap<Float, Vehicle>();
        for (int lap = 0; lap < 50; lap++) {

            this.raceWeather.setRaining();
            System.out.println(this.name);
            System.out.println(String.format("Lap: %s", lap + 1));
            System.out.println(String.format("Raining?:%s", this.raceWeather.isRaining()));
            System.out.println("\n");


        }
    }

    public void printRaceResults() {

    }

    public boolean isThereABrokenTruck() {
        return true;
    }

}
