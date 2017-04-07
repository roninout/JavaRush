package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) return;
        String filename = args[0];
        TreeMap<Integer,Integer> map = new TreeMap<>();

        FileInputStream in1 = new FileInputStream(filename);

        while (in1.available() > 0){
            int key = in1.read();
            map.put(key, !map.containsKey(key) ? 1 : map.get(key) + 1);
        }

        in1.close();

        for (Map.Entry<Integer,Integer> anMap: map.entrySet())
            System.out.printf("%s %d%n", Character.toString((char)((int)anMap.getKey())), anMap.getValue());
    }
}
