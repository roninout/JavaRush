package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        TreeSet<Integer> map = new TreeSet<>();

        while (fileInputStream.available() > 0)
            map.add(fileInputStream.read());

        reader.close();
        fileInputStream.close();

        for (Integer anMap : map)
            System.out.print(anMap + " ");
    }
}
