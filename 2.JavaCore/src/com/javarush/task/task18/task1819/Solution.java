package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();

        FileInputStream in1 = new FileInputStream(fileName1);

        int count1 = 0;
        byte[] buffer1 = null;
        if(in1.available() > 0){
            buffer1 = new byte[in1.available()]; //читаем весь файл одним куском
            count1 = in1.read(buffer1); // количество байт
        }
        in1.close();

        FileInputStream in2 = new FileInputStream(fileName2);
        FileOutputStream out1 = new FileOutputStream(fileName1);

        int count2 = 0;
        byte[] buffer2 = null;
        if(in2.available() > 0){
            buffer2 = new byte[in2.available()]; //читаем весь файл одним куском
            count2 = in2.read(buffer2); // количество байт
        }
        in2.close();

        out1.write(buffer2, 0 ,count2);
        out1.write(buffer1, 0 ,count1);

        reader.close();
        out1.close();

    }
}
