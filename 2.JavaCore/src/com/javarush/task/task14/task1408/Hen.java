package com.javarush.task.task14.task1408;

/**
 * Created by Kovalchuk_A on 22.03.2017.
 */
public abstract class Hen {
    abstract int getCountOfEggsPerMonth();

    public String getDescription(){
        return "Я - курица.";
    }
}
