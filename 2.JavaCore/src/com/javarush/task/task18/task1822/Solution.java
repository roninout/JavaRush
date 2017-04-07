package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream in = new FileInputStream(reader.readLine());
        Scanner scanner = new Scanner(in);

        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            String [] word = line.split(" ");
            if (word[0].equals(args[0])) {
                System.out.println(line);
                break;
            }
        }
        reader.close();
        in.close();
        scanner.close();
    }
}
