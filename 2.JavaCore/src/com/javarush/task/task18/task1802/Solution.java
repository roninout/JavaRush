package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());

        int max = inputStream.read();
        while (inputStream.available() > 0){
            int temp = inputStream.read();
            if (max > temp)
                max = temp;
        }

        reader.close();
        inputStream.close();

        System.out.println(max);
    }
}
