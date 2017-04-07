package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer,byte[]> map = new TreeMap<>();
        String fullName = null;

        while (true){
            String fileName = reader.readLine();
            if (fileName.equals("end")) break;

            fullName = fileName.substring(0, fileName.lastIndexOf("."));

            FileInputStream inputStream = new FileInputStream(fileName);
            if (inputStream.available() > 0)
            {
                byte [] buffer = new byte[inputStream.available()];
                inputStream.read(buffer);
                int part = Integer.parseInt(fileName.substring(fileName.lastIndexOf("part")+4));
                map.put(part, buffer);
            }
            inputStream.close();

        }
        reader.close();

        FileOutputStream out = new FileOutputStream(fullName);

        for (Map.Entry<Integer, byte[]> anMap:map.entrySet()) {
            out.write(anMap.getValue());
        }
        out.close();
    }
}
