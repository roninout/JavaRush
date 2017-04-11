package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String tag = args[0];
        if (tag == null ||tag.length() == 0) return;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));

        List<String> list = new ArrayList<>();

        String line = "";
        while(file.ready())
            line += file.readLine();

        reader.close();
        file.close();

        while (line.contains(tag))
        {
            String tempLine = line.substring(line.indexOf("<" + tag) + tag.length() + 1, line.indexOf("</" + tag + ">"));
            while (tempLine.contains("<" + tag))
            {
                if (tempLine.contains("<" + tag))
                    tempLine = tempLine.substring(tempLine.indexOf(tag + ">") + tag.length() + 1, tempLine.length());
            }
            list.add("<" + tag + ">" + tempLine + "</" + tag + ">");
            line = line.replaceAll(tempLine, "");
        }

        for (String lst : list)
            System.out.println(lst);
        System.out.println(line);
    }
}
