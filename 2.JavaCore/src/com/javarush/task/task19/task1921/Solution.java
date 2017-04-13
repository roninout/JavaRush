package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException{
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));

        while (fileReader.ready()){
            String line = fileReader.readLine();
            String [] word = line.split(" ");

            String year = word[word.length - 1];
            String month = word[word.length - 2];
            String day = word[word.length - 3];
            String name = line.substring(0, line.indexOf(day) - 1);

            String pattern = "dd MM yyyy";
            Date birthDate=null;
            SimpleDateFormat df = new SimpleDateFormat(pattern, Locale.ENGLISH);

            try
            {
                birthDate = df.parse(day +" "+ month + " " + year);
            }catch (Exception e)
            {
                System.out.println("ERROR: wrong date format");
            }

            PEOPLE.add(new Person(name, birthDate));
        }

        for (Person result : PEOPLE)
        {
            System.out.println(result.getName() +" "+ result.getBirthday());
        }


        fileReader.close();
    }
}
