package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        Map<Integer,Integer> map = new HashMap<>();

        while (inputStream.available() > 0){
            int readByte = inputStream.read();
            if(!map.containsKey(readByte))
                map.put(readByte,1);
            else
                map.put(readByte,map.get(readByte)+1);
        }

        reader.close();
        inputStream.close();


        int max = 0;
        for (Map.Entry<Integer, Integer> anMap : map.entrySet()) {
            if (max < anMap.getValue())
                max = anMap.getValue();
        }

        for (Map.Entry<Integer, Integer> anMap : map.entrySet()) {
            if (anMap.getValue() == max)
                System.out.print(anMap.getKey() + " ");
        }
    }
}
