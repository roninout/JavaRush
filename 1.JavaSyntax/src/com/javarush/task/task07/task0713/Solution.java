package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> sList = new ArrayList<Integer>();
        ArrayList<Integer> evenList = new ArrayList<Integer>();
        ArrayList<Integer> oddList = new ArrayList<Integer>();
        ArrayList<Integer> otherList = new ArrayList<Integer>();


        for (int i = 0; i < 20; i++)
            sList.add(Integer.parseInt(reader.readLine()));

        for (int x : sList)
        {
            if (x % 3 == 0 && x % 2 == 0)
            {
                evenList.add(x);
                oddList.add(x);
            } else if (x % 3 == 0 )
            {
                evenList.add(x);
            } else if (x % 2 == 0)
            {
                oddList.add(x);

            } else
            {
                otherList.add(x);
            }
        }

        printList(evenList);
        printList(oddList);
        printList(otherList);
    }

    public static void printList(List<Integer> list)
    {
        //напишите тут ваш код
        for (Integer anList : list)
            System.out.println(anList);
    }
}
