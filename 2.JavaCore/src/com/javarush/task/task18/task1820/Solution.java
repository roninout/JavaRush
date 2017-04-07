package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        FileInputStream in1 = new FileInputStream(fileName1);
        Scanner scanner = new Scanner(in1);
        FileWriter out2 = new FileWriter(fileName2);

        String [] word = null;
        while (scanner.hasNextLine())
            word = scanner.nextLine().split(" ");

        for (String anWord : word)
            out2.write(Math.round(Double.parseDouble(anWord)) + " ");

        reader.close();
        in1.close();
        scanner.close();
        out2.close();
    }
}
