package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int [] array = new int[10];

        for (int i = 0; i < array.length; i++)
            array[(array.length - 1) - i] = Integer.parseInt(reader.readLine());

        for (int anArray : array) System.out.println(anArray);
    }
}

