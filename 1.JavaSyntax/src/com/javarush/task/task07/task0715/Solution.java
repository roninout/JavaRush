package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        String str =  "именно";
        list.add("мама");
        list.add(str);
        list.add("мыла");
        list.add(str);
        list.add("раму");
        list.add(str);

        for (String anList: list)
            System.out.println(anList);
    }
}
