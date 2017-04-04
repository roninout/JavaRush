package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileInputStream in = new FileInputStream(file1);
        FileOutputStream out = new FileOutputStream(file2);

        if(in.available() > 0){
            byte[] buffer = new byte[in.available()]; //читаем весь файл одним куском
            int count = in.read(buffer); // количество байт

            for (int i = count; i > 0; i--)
                out.write(buffer[i-1]);
        }

        reader.close();
        in.close();
        out.close();
    }
}
