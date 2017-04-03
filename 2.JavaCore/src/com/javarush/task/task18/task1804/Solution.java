package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        Map<Integer,Integer> map = new HashMap<>();

        while (fileInputStream.available() > 0){
            int readByte = fileInputStream.read();
            if(!map.containsKey(readByte))
                map.put(readByte, 1);
            else
                map.put(readByte,map.get(readByte)+1);
        }

        reader.close();
        fileInputStream.close();


        // первый елемент в мар-е
        int min = 0;


        try {
            Map.Entry<Integer,Integer> first = map.entrySet().iterator().next();
            min = first.getValue();
        }
        catch (NoSuchElementException e) {}

        for (Map.Entry<Integer, Integer> anMap : map.entrySet())
        {
            if (anMap.getValue() < min)
                min = anMap.getValue();
        }

        for (Map.Entry<Integer, Integer> mapresult : map.entrySet())
        {
            if (mapresult.getValue() == min)
                System.out.print(mapresult.getKey() + " ");
        }
    }
}
