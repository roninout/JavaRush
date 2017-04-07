package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = null;
        String filename = null;

        while (true){
            try {
                filename = reader.readLine();
                inputStream = new FileInputStream(filename);
                inputStream.close();
            } catch (FileNotFoundException e) {
                break;
            }
        }
        reader.close();
        System.out.println(filename);
    }
}
