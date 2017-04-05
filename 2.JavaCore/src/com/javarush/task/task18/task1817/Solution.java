package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.*;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {
        int count_space = 0;
        int count_all = 0;
        Double result = 0.0;

        if(args.length > 0){
            FileInputStream in = new FileInputStream(args[0]);

            while(in.available() > 0){
                int data = in.read();
                if(data == Integer.valueOf(' '))
                    count_space++;
                count_all++;
            }
            in.close();
        }

        if (count_all > 0 && count_space > 0)
            result = (double) count_space/count_all*100;

        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(df.format(result));
    }
}
