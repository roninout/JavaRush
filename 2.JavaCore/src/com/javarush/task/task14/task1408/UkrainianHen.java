package com.javarush.task.task14.task1408;

/**
 * Created by Kovalchuk_A on 22.03.2017.
 */
public class UkrainianHen extends Hen{
    @Override
    int getCountOfEggsPerMonth() {
        return 20;
    }

    @Override
    public String getDescription() {
        return String.format("%s Моя страна - %s. Я несу %d яиц в месяц.", super.getDescription(), Country.UKRAINE, getCountOfEggsPerMonth());
    }
}
