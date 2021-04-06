package com.javarush.task.task21.task2113;

import java.util.Random;

public class Horse {
    public String getName() {
        return name;
    }

    public void move(){
        distance+=speed*Math.random();
    }
    public void print(){
        Double d = distance;
        for (int i = 0; i < d.intValue(); i++) {
            System.out.print(".");
        }
        System.out.println(getName());
    }
    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    String name;
    double speed;
    double distance;
}
