package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        FileWriter fileWriter = new FileWriter(args[1]);
        ArrayList<String> list = new ArrayList<>();

        while (fileReader.ready())
        {
            String [] word = fileReader.readLine().split(" ");
            for (String anWord : word) {
                if (anWord.length() > 6)
                    list.add(anWord);
            }
        }

        for (int i = 0; i < list.size(); i++)
            fileWriter.write(!list.get(i).equals(list.get(list.size() - 1)) ? list.get(i) + ", " : list.get(i));

        fileReader.close();
        fileWriter.close();
    }
}
