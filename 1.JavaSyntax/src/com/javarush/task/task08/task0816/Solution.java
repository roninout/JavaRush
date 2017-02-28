package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));

        //напишите тут ваш код
        map.put("A", new Date("MAY 1 1980"));
        map.put("B", new Date("JUNE 1 1980"));
        map.put("C", new Date("JULY 1 1980"));
        map.put("D", new Date("AUGUST 1 1980"));
        map.put("Q", new Date("JUNE 1 1980"));
        map.put("W", new Date("MAY 1 1980"));
        map.put("E", new Date("JUNE 1 1980"));
        map.put("R", new Date("MARCH 1 1980"));
        map.put("T", new Date("JUNE 1 1980"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        //map.entrySet().removeIf(pair -> pair.getValue().getMonth() == 5 || pair.getValue().getMonth() == 6|| pair.getValue().getMonth() == 7);

        Iterator<Map.Entry<String,Date>> iterator = map.entrySet().iterator();

        while(iterator.hasNext())
        {
            Map.Entry<String,Date> pair = iterator.next();
            Date value = pair.getValue();
            int rad = value.getMonth();
            if(rad == 5 || rad == 6 || rad == 7)
                iterator.remove();
        }
    }

    public static void main(String[] args) {
        HashMap<String, Date> map = createMap();
        removeAllSummerPeople(map);

        for (Map.Entry<String, Date> anMap: map.entrySet())
            System.out.println(anMap.getValue());
    }
}
