package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        int min = 0;
        int max = 0;

        for (int i = 0; i < 10; i++)
            list.add(reader.readLine());

        for (int i = 1; i < list.size(); i++) {
            if (list.get(max).length() < list.get(i).length())
                max = i;

            if (list.get(min).length() > list.get(i).length())
                min = i;

        }

        System.out.println(max < min ? list.get(max) : list.get(min));
    }
}
