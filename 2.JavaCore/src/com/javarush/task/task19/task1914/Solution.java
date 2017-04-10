package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        System.setOut(printStream);
        testString.printSomething();

        String result = outputStream.toString();

        System.setOut(consoleStream);

        String [] numb = result.split(" ");
        result = String.format("%s %s %s %s ", numb[0], numb[1], numb[2], numb[3]);

        switch (numb[1]) {
            case "+":
                result += Integer.parseInt(numb[0]) + Integer.parseInt(numb[2]);
                break;
            case "-":
                result += Integer.parseInt(numb[0]) - Integer.parseInt(numb[2]);
                break;
            case "*":
                result += Integer.parseInt(numb[0]) * Integer.parseInt(numb[2]);
                break;
            default:
                break;
        }
        System.out.print(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

