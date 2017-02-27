package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int [] bigArray = new int[20];
        int [] firstArray = new int[10];
        int [] secondArray = new int[10];

        for (int i = 0; i < bigArray.length; i++) {
            bigArray[i] = Integer.parseInt(reader.readLine());
            if (i < 10)
                firstArray[i] = bigArray[i];
            else
                secondArray[i - 10] = bigArray[i];
        }

        for (int anArray : secondArray) System.out.println(anArray);
    }
}
