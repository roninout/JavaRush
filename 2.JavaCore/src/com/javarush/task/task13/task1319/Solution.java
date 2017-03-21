package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;

/* 
Запись в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        String fileName = reader.readLine();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));

        for (;true;) {
            String input = reader.readLine();
            list.add(input);
            if (input.equals("exit")) break;
        }

        for (String anList: list)
            bufferedWriter.write(anList + System.getProperty( "line.separator" ));

        reader.close();
        bufferedWriter.close();
    }
}
