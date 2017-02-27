package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count=0;
        double sum = 0;

        for (;true;)
        {
            int a = Integer.parseInt(reader.readLine());
            if (a == -1) break;
            sum+=a;
            count++;
        }
        System.out.println(sum/count);
    }
}

