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
        Map<Vehicle, Double> standings = new HashMap<Vehicle, Double>();
        for (int lap = 0; lap < 50; lap++) {

            this.raceWeather.setRaining();
            System.out.println();
            System.out.println(this.name);
            System.out.println(String.format("Lap: %s", lap + 1));
            System.out.println(String.format("Raining?:%s", this.raceWeather.isRaining()));
            System.out.println("\n");


            for (Vehicle vehicle: competitors
                 ) {
                if(raceWeather.isRaining()){
                    vehicle.prepareForLapRain();
                }

                if(isThereABrokenTruck()) {
                    vehicle.prepareForLapTruckDown();
                } else {
                    vehicle.prepareForLap();
                }

                vehicle.moveForAnHour();

                standings.put(vehicle, vehicle.getDistanceTraveled());

            }

            printRaceResults(standings);
        }
    }

    public void printRaceResults(Map<Vehicle, Double> standings) {

        List<Map.Entry<Vehicle,Double>> competitorsByDistance = new ArrayList<Map.Entry<Vehicle,Double>>(standings.entrySet());
        Collections.sort(competitorsByDistance, new Comparator<Map.Entry<Vehicle, Double>>() {
            @Override
            public int compare(Map.Entry<Vehicle, Double> vehicleDoubleEntry, Map.Entry<Vehicle, Double> t1) {
               return t1.getValue().compareTo(vehicleDoubleEntry.getValue());
            }
        });

        for ( Map.Entry<Vehicle, Double> vehicle: competitorsByDistance
             ) {
            System.out.println(vehicle.toString());
        }

    }

    public boolean isThereABrokenTruck() {
        for (Vehicle vehicle:competitors
             ) {
            if(vehicle.getClass().toString().contains("Truck")){
                if(((Truck)vehicle).isBroken()) {
                    return true;
                }
            }
        }
        return false;
    }

}
