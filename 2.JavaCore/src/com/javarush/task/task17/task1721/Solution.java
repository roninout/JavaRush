package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();

        readFileToList(firstFileName, allLines);
        readFileToList(secondFileName, forRemoveLines);
        try
        {
            new Solution().joinData();
        }
        catch (CorruptedDataException e)
        {
            e.printStackTrace();
        }

        reader.close();
    }

    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines))
            allLines.removeAll(forRemoveLines);
        else
        {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }

    public static void readFileToList(String FileName, List<String> list) throws FileNotFoundException
    {
        InputStream inputStream = new FileInputStream(FileName);
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine())
            list.add(scanner.nextLine());
        scanner.close();
    }
}
