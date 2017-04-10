package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        FileInputStream in2 = new FileInputStream(file2);
        FileInputStream in3 = new FileInputStream(file3);
        FileOutputStream out1 = new FileOutputStream(file1);

        if(in2.available() > 0){
            byte[] buffer = new byte[in2.available()]; //читаем весь файл одним куском
            int count2 = in2.read(buffer); // количество байт
            out1.write(buffer,0,count2);

        }

        if(in3.available() > 0){
            byte[] buffer = new byte[in3.available()]; //читаем весь файл одним куском
            int count = in3.read(buffer); // количество байт
            out1.write(buffer,0,count);
        }

        reader.close();
        in2.close();
        in3.close();
        out1.close();
    }
}
