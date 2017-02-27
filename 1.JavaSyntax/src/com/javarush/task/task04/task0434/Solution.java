package com.javarush.task.task04.task0434;


/* 
Таблица умножения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int h = 1;
        while (h <= 10)
        {
            int v = 1;
            while(v <= 10)
            {
                System.out.print(h*v +" ");
                v++;
            }
            System.out.println();
            h++;
        }
    }
}
