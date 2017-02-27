package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int count = 1, result = 0;


        for (int i = 0; i < 10; i++)
            list.add(Integer.parseInt(reader.readLine()));

        Collections.sort(list);


        for (int i = 0; i < list.size() - 1; i++)
        {
            if (list.get(i).equals(list.get(i +1))) {
                count++;
                if (result < count)
                    result = count;
            }
            else
                count = 1;
        }
            System.out.println(result);

    }
}