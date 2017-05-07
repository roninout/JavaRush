package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {
        //...
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine())))
        {
            String line = "";
            while(fileReader.ready())
                line = fileReader.readLine();

            StringBuilder result = getLine(line.split(" "));
            System.out.println(result.toString());
        }
        catch (IOException e) { e.printStackTrace(); }
    }

    public static StringBuilder getLine(String... words)
    {
        StringBuilder builder = new StringBuilder();

        if (words == null || words.length == 0)
            return builder;
        if (words.length == 1) // <---- это ВАЖНО
            return builder.append(words[0]);

        ArrayList<String> list = new ArrayList<>();

        Collections.addAll(list, words);

        boolean done = false;
        while(!done)
        {
            Collections.shuffle(list); // встряхиваем массив

            for (int i = 0; i < list.size()-1; i++)
            {
                String first = list.get(i).toLowerCase();
                String second = list.get(i+1).toLowerCase();
                char a = first.charAt(first.length()-1);
                char b = second.charAt(0);
                if (a != b)
                    break;
                if (i == list.size() - 2)
                    done = true;
            }
        }

        for (String word : list)
            builder.append(word).append(" ");

        return builder.deleteCharAt(builder.length()-1);
    }
}
