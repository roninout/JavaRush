package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static
    {
        try
        {
            InputStream inputStream = new FileInputStream(Statics.FILE_NAME);
            Scanner scanner = new Scanner(inputStream);

            while (scanner.hasNextLine()) lines.add(scanner.nextLine());

            scanner.close();
            inputStream.close();
        }
        catch (IOException e) {}
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
