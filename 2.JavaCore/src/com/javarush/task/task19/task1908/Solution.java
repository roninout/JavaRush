package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();


        while (fileReader.ready())
        {
            String [] word = fileReader.readLine().split(" ");
            for (String anWord : word) {
                Pattern p = Pattern.compile("[0-9]+"); // 0-9 - проверка на цифры, + - проверяет не только один символ
                Matcher m = p.matcher(anWord);
                if (m.matches())
                    fileWriter.write(anWord + " ");
            }
        }

        fileReader.close();
        fileWriter.close();
    }
}
