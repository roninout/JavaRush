package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException
    {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String[] array = url.substring(url.indexOf("?") + 1).split("&"); //разбиваем на параметр=значение
        List<String> list = new ArrayList<>();

        for (String unparsed :  //пробегаемся по параметр=значение
                array)
        {
            String[] paramAndValue; // массив где 0 = параметр, 1 = значение
            if (unparsed.contains("="))
            {
                paramAndValue = unparsed.split("="); //наполняем массив
                if (paramAndValue[0].equals("obj"))
                    list.add(paramAndValue[1]); //добавляем значение параметра obj в список

                System.out.print(paramAndValue[0] + " "); //выводим параметр
            } else
                System.out.print(unparsed + " "); //выводим параметр в случае если у него нет значения
        }
        System.out.println();

        for (String string : //выводим все значение obj
                list)
        {
            if (string.matches("[0-9]+(?:\\.[0-9]*)?"))
                alert(Double.parseDouble(string));
            else
                alert(string);
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
