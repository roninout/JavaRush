package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int [] arr = new int[20];

        //напишите тут ваш код
        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(reader.readLine());

        int maximum = arr[0];
        int minimum = arr[0];

        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] < minimum)
                minimum = arr[i];
            if (arr[i] > maximum)
                maximum = arr[i];
        }


        System.out.print(maximum);
        System.out.print(" " +minimum);
    }
}
