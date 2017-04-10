package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        FileReader fileReader = new FileReader(fileName1);
        FileWriter fileWriter = new FileWriter(fileName2);

        int count = 1;

        while (fileReader.ready())
        {
            int data = fileReader.read();
            if (count % 2 == 0)
                fileWriter.write(data);
            count++;
        }

        fileReader.close();
        fileWriter.close();
        reader.close();
    }
}
