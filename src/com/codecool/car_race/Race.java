package com.codecool.car_race;

import javax.sound.midi.Soundbank;
import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {

    String[] names = new String[]{"Le Mans", "Talladega", "Monza", "Spa Francorchamps", "Daytona 500"};
    String name;

    private List<Vehicle> carList = new ArrayList<>();
    private List<Vehicle> motoList = new ArrayList<>();
    private List<Vehicle> truckList = new ArrayList<>();


    public Race() {
        Random random = new Random();
        this.name = names[random.nextInt(names.length)];
    }

    public void registerRacer(Vehicle vehicle) {

        String vehicleSubClassName = vehicle.getClass().toString().substring(28);

        switch (vehicleSubClassName) {
            case "Car":
                carList.add(vehicle);
                break;
            case "Motorcycle":
                motoList.add(vehicle);
                break;
            case "Truck":
                truckList.add(vehicle);
                break;
            default:
                break;
        }
    }

    public void simulateRace() {
        for (int lap = 0; lap < 50; lap++) {
            Weather.setRaining();
            System.out.println(String.format("Lap: %s", lap+1));
            System.out.println(String.format("Raining?:%s", Weather.isRaining()));
            System.out.println("\n");

            for (Vehicle moto : motoList
            ) {
                moto = (Motorcycle) moto;
                if (Weather.isRaining()) {
                    moto.prepareForLap(this, 0);
                } else {
                    moto.prepareForLap(this);
                }
                moto.moveForAnHour();
            }

            for (Vehicle truck : truckList
            ) {
                truck = (Truck) truck;
                truck.prepareForLap(this);
                truck.moveForAnHour();
            }

            for (Vehicle car : carList
            ) {
                car = (Car) car;
                if (isThereABrokenTruck()) {
                    car.prepareForLap(this, 75);
                } else {
                    car.prepareForLap(this);
                }
                car.moveForAnHour();
            }
            printRaceResults();
        }
    }

    public void printRaceResults() {
        System.out.println("---CARS---");
        for (Vehicle car : carList
        ) {
            car = (Car) car;
            System.out.println(car.toString());
        }
        System.out.println("---------");
        System.out.println("---MOTORCYCLES---");
        for (Vehicle motos : motoList
        ) {
            motos = (Motorcycle) motos;
            System.out.println(motos.toString());
        }
        System.out.println("---------");
        System.out.println("---TRUCKS---");
        for (Vehicle truck : truckList
        ) {
            truck = (Truck) truck;
            System.out.println(truck.toString());
        }
        System.out.println("---------");
    }

    public boolean isThereABrokenTruck() {


        Truck currentTruck = new Truck();
        for (Vehicle truck : truckList
        ) {

            currentTruck = (Truck) truck;
            if (currentTruck.isBroken()) {
                return true;
            }
        }
        return false;
    }

}
