package com.javarush.task.task08.task0827;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
//        System.out.println(isDateOdd("JANUARY 2 2020"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MMM d yyyy", Locale.US);
        Date yearStartTime = formatter.parse(date);
        Date currentTime = new Date();

        long msTimeDistance = Math.abs(currentTime.getTime() - yearStartTime.getTime());
        long msDay = 24 * 60 * 60 * 1000;  //сколько миллисекунд в одних сутках

        int dayCount = (int) (msTimeDistance/msDay + 1); //количество целых дней
        System.out.println("Days from start of year: " + dayCount);

        return dayCount % 2 != 0;
    }
}
