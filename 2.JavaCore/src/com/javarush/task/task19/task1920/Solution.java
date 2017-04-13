package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> map = new TreeMap<>();

        while (fileReader.ready()) {
            String[] word = fileReader.readLine().split(" ");

            String name = word[0];
            Double value = Double.parseDouble(word[1]);

            map.put(name, map.containsKey(name) ? Double.valueOf(map.get(name) + value) : value);
        }

        Double max = Double.MIN_VALUE;

        for (Map.Entry<String, Double> anMap : map.entrySet())
            if (max < anMap.getValue()) max = anMap.getValue();

        for (Map.Entry<String, Double> anMap : map.entrySet())
            if (anMap.getValue().equals(max)) System.out.println(anMap.getKey());

        fileReader.close();
    }
}
