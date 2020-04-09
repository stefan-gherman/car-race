package com.codecool.car_race;

public abstract  class Vehicle implements Auto {
    int distanceTraveled = 0;
    int speed = 0;
    String name;

    private void moveForAnHour() {
        distanceTraveled += 10;
    }

    public String toString() {
        return String.format("%s %s %s", this.name, this.speed, this.distanceTraveled);
    }
}
