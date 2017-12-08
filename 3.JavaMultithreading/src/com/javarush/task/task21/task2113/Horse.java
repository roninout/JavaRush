package com.javarush.task.task21.task2113;

/**
 * Created by alexanderkovalchuk on 29.04.17.
 */
public class Horse {
    public String name;
    public double speed;
    public double distance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public void move(){
        distance += speed * Math.random();
    }

    public void print(){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < (int) distance; i++)
            str.append(".");
        str.append(name);
        System.out.println(str);
    }
}