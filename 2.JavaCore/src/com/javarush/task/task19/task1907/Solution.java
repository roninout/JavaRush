package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();

        int count = 0;

        while (fileReader.ready())
        {
            String [] word = fileReader.readLine().split("[., !?;:-]");
            for (String anWord : word) {
                if (anWord.toLowerCase().equals("world")) count ++;
            }
        }


        fileReader.close();

        System.out.println(count);
    }
}
