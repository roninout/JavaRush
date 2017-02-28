package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String,String> map = new HashMap<>();
        map.put("f1", "Pupkin");
        map.put("f2", "Vasilov");
        map.put("f3", "Smith");
        map.put("f4", "Ericman");
        map.put("f5", "Stellov");
        map.put("f6", "Testerov");
        map.put("f7", "Pushkin");
        map.put("f8", "Alexov");
        map.put("f9", "Alexov1");
        map.put("f10", "Alexov");

        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, String> pair : map.entrySet())
            list.add(pair.getValue());

        for (int i = 0; i < list.size()-1; i++){
            for (int j = i+1; j < list.size(); j++){
                if (list.get(i).equals(list.get(j)))
                    removeItemFromMapByValue(map, list.get(i));
            }
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);

        for (Map.Entry<String,String> pair: map.entrySet()){
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }
}
