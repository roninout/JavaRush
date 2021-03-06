package com.javarush.task.task07.task0716;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); //0
        list.add("лоза"); //1
        list.add("лира"); //2
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        //напишите тут ваш код
        ArrayList<String> fixList = new ArrayList<>();

        for (String anList : list)
        {
            if (anList.contains("л") && anList.contains("р")) {
                fixList.add(anList);
                continue;
            }

            if (anList.contains("л"))
            {
                fixList.add(anList);
                fixList.add(anList);
                continue;
            }

            if (anList.contains("р"))
                continue;

            fixList.add(anList);
        }

        return fixList;
    }
}