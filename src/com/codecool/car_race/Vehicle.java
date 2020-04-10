package com.codecool.car_race;

public abstract  class Vehicle implements Auto {
    private int distanceTraveled = 0;
    private int speed = 0;
    private String name;

    public void moveForAnHour() {
        this.distanceTraveled += 10;
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

    public int getDistanceTraveled() {
        return this.distanceTraveled;
    }

    public String toString() {
        return String.format("%s speed: %s distance: %s type: %s", this.name, this.speed, this.distanceTraveled, this.getClass().toString().substring(28));
    }
}
