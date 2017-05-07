package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

        getTokens("level22.lesson13.task01", ".");
    }

    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);

        ArrayList<String> list = new ArrayList<>();

        while (stringTokenizer.hasMoreTokens())
            list.add(stringTokenizer.nextToken());

        return list.toArray(new String[list.size()]);
    }
}
