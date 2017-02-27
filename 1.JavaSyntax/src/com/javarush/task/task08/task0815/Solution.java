package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("q","aa");
        map.put("w","12");
        map.put("e","aa");
        map.put("r","14");
        map.put("t","bb");
        map.put("y","16");
        map.put("u","bb");
        map.put("i","18");
        map.put("o","19");
        map.put("p","10");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;
        for (Map.Entry<String, String> anMap: map.entrySet())
        {
            if (anMap.getValue().equals(name)) count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int count = 0;
        for (Map.Entry<String, String> anMap: map.entrySet())
        {
            if (anMap.getKey().equals(lastName)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        System.out.println(getCountTheSameFirstName(map, "aa"));
        System.out.println(getCountTheSameLastName(map, "u"));

    }
}
