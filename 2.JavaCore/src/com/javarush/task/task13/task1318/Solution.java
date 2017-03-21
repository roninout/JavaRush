package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        InputStream inputStream = new FileInputStream(fileName);
        byte [] data = new byte[inputStream.available()];

        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) inputStream.read();
        }

        reader.close();
        inputStream.close();

        System.out.println(new String(data));
    }
}