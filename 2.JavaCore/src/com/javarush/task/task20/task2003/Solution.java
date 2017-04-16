package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            load(new FileInputStream(reader.readLine()));
            reader.close();
        }
        catch (Exception E){E.printStackTrace();}
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties proper = new Properties();
        try
        {
            for (Map.Entry<String,String> map : properties.entrySet()) // проходим по карте
                proper.put(map.getKey(),map.getValue()); // наполняем свойства значениями из карты

            proper.store(outputStream, null); // сохраняем свойства в файл без коментов
            outputStream.close();
        }catch (IOException e) {e.printStackTrace();}
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        try
        {
            prop.load(inputStream); // загружаем данные из файла
            for (String s : prop.stringPropertyNames()) // проходим по свойствам
                properties.put(s, prop.getProperty(s)); // и заполняем карту значениями
            inputStream.close(); // закрываем поток
        }catch (Exception e){e.printStackTrace();}
    }

    public static void main(String[] args) {

        Solution sol = new Solution();
        sol.fillInPropertiesMap();

    }
}
