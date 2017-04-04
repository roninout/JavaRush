package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        int count = 0;
        while (fileInputStream.available() > 0)
        {
            if (fileInputStream.read() == 44)
                count++;
        }

        reader.close();
        fileInputStream.close();

        System.out.println(count);
    }
}
