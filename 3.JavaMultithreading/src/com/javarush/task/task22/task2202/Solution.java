package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString(""));
        System.out.println(getPartOfString("abcde"));
        System.out.println(getPartOfString("a b c d e"));
    }

    public static String getPartOfString(String string) {

        if (string == null) throw new TooShortStringException();

        String result = "";
        String [] words = string.split(" ");

        if (words.length < 5) throw new TooShortStringException();
        if (words[4].equals("")) throw new TooShortStringException(); // костыль

        for (int i = 1; i <= 4; i++)
            result += words[i] + " ";
        return result.trim();
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
