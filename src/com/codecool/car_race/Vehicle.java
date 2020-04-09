package com.codecool.car_race;

public abstract  class Vehicle implements Auto {
    private int distanceTraveled = 0;
    private int speed = 0;
    private String name;

    private void moveForAnHour() {
        distanceTraveled += 10;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return String.format("%s %s %s", this.name, this.speed, this.distanceTraveled);
    }
}
