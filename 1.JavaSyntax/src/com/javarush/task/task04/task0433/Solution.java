package com.javarush.task.task04.task0433;


/* 
Гадание на долларовый счет
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int h = 10;
        while (h > 0)
        {
            int v = 10;
            while(v > 0)
            {
                System.out.print("S");
                v--;
            }
            System.out.println();
            h--;
        }
    }
}
