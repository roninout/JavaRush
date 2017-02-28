package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        map.put("f1", 1234);
        map.put("f2", 34);
        map.put("f3", 500);
        map.put("f4", 2);
        map.put("f5", 43);
        map.put("f6", 2342);
        map.put("f7", 343);
        map.put("f8", 34);
        map.put("f9", 12);
        map.put("f10", 43);

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();

        while(iterator.hasNext())
        {
            Map.Entry<String,Integer> pair = iterator.next();
            if(pair.getValue() < 500)
                iterator.remove();
        }
    }

    public static void main(String[] args) {

        HashMap<String, Integer> map = createMap();
        removeItemFromMap(map);

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }
}