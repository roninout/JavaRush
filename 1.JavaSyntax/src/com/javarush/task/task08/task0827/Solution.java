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
        System.out.println(isDateOdd("JANUARY 1 2000"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        Date dat_new = new Date(date);
        Date start_year = new Date(date);
        start_year.setHours(0);
        start_year.setMinutes(0);
        start_year.setSeconds(0);
        start_year.setDate(1);
        start_year.setMonth(0);
        long d = dat_new.getTime() - start_year.getTime();
        long ms = 1000*60*60*24;
        int dayCount = (int)(d/ms);
        return dayCount % 2 == 0;
    }
}
