package com.javarush.task.task14.task1419;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        try {
            throw new ArrayIndexOutOfBoundsException(100);
        } catch (Exception e) {
            exceptions.add(e);
        }
        //3
        try {
            throw new NumberFormatException("123abc");
        } catch (Exception e) {
            exceptions.add(e);
        }
        //4
        try {
            throw new ArrayStoreException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        //5
        try {
            throw new ClassCastException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        //6
        try {
            throw new NegativeArraySizeException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        //7
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        //8
        try {
            throw new StringIndexOutOfBoundsException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        //9
        try {
            throw new FileNotFoundException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        //10
        try {
            throw new InterruptedException();
        } catch (Exception e) {
            exceptions.add(e);
        }
    }
}
