package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a =Integer.parseInt(reader.readLine());
        int b =Integer.parseInt(reader.readLine());
        String s1 = "";

        if (a>0 && b>0) s1 = "1";
        if (a<0 && b>0) s1 = "2";
        if (a<0 && b<0) s1 = "3";
        if (a>0 && b<0) s1 = "4";
        System.out.println(s1);
    }
}
