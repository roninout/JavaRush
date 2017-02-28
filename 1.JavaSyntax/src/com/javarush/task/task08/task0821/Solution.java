package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("f1", "petr");
        map.put("f2", "anna");
        map.put("f3", "igor");
        map.put("f4", "artem");
        map.put("f5", "sasha");
        map.put("f6", "petr");
        map.put("f7", "anna");
        map.put("f2", "igor");
        map.put("f9", "artem");
        map.put("f10", "sasha");

        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
