package com.codecool.car_race;

public abstract  class Vehicle implements Auto {
    private double distanceTraveled = 0;
    private int speed = 0;
    private String name;
    private final int HOUR_IN_SECONDS = 3600;

    public abstract void moveForAnHour();

    public int getHOUR_IN_SECONDS() {
        return HOUR_IN_SECONDS;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDistanceTraveled(double distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public double getDistanceTraveled() {
        return this.distanceTraveled;
    }

    @Override
    public void prepareForLapRain() {

    }

    @Override
    public void prepareForLapTruckDown() {

    }

    @Override
    public void prepareForLap() {

    }

    public String toString() {
        return String.format("%s speed: %s distance: %s type: %s", this.name, this.speed, this.distanceTraveled, this.getClass().toString().substring(28));
    }
}
