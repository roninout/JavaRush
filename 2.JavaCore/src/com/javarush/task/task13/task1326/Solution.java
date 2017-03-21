package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new FileInputStream(reader.readLine()));
        ArrayList<Integer> list = new ArrayList<>();

        while (scanner.hasNextLine())
            list.add(Integer.parseInt(scanner.nextLine()));

        Collections.sort(list);

        reader.close();
        scanner.close();

        for (Integer anList: list) {
            if (anList% 2 == 0)
                System.out.println(anList);
        }
    }
}
