package com.javarush.task.task22.task2212;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || telNumber.equals("")) return false;

        Pattern p;
        Matcher m;

        //1) если номер начинается с '+', то он содержит 12 цифр
        p = Pattern.compile("^\\+[0-9]{12}");
        m = p.matcher(telNumber);
        if (m.matches()) return true;

        //2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
        p = Pattern.compile("^(\\(|\\d)[0-9]{10}");
        m = p.matcher(telNumber);
        if (m.matches()) return true;

        //3) может содержать 0-2 знаков '-', которые не могут идти подряд
        //p = Pattern.compile("[-]{0,2}");
        //m = p.matcher(telNumber);
        //if (!m.matches()) return false;

        //4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
        p = Pattern.compile("^(\\(|\\d)[0-9]{10}");
        m = p.matcher(telNumber);
        if (m.matches()) return true;

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("050123-4567"));

        System.out.println(checkTelNumber("+38)050(1234567"));
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println(checkTelNumber("050ххх4567"));
        System.out.println(checkTelNumber("050123456"));
        System.out.println(checkTelNumber("(0)501234567"));
    }
}
