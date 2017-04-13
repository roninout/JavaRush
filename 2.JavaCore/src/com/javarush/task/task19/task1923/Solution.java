package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        FileWriter fileWriter = new FileWriter(args[1]);

        while (fileReader.ready()){
            String [] word = fileReader.readLine().split(" ");
            for (String anWord : word) {
                if (!anWord.matches("^\\D*$"))
                    fileWriter.write(anWord + " ");
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
