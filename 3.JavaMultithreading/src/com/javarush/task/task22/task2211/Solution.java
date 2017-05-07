package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args){
        try(FileInputStream inputStream = new FileInputStream(args[0]);
            FileOutputStream outputStream = new FileOutputStream(args[1]))
        {
            Charset utf8 = Charset.forName("UTF-8");
            Charset windows1251 = Charset.forName("Windows-1251");

            if (inputStream.available() > 0){
                byte[] buffer = new byte[inputStream.available()]; //читаем весь файл одним куском
                inputStream.read(buffer);

                String s = new String(buffer, utf8);
                buffer = s.getBytes(windows1251);
                outputStream.write(buffer);
            }
        }
        catch (IOException e)
        {e.printStackTrace();}
    }
}
