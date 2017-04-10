package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }


        @Override
        public Person read() throws IOException {
            if (fileScanner.hasNextLine()){
                String [] word = fileScanner.nextLine().split("");
                String firstName = word[0];
                String middleName = word[1];
                String lastName = word[2];

                Calendar calendar = new GregorianCalendar(Integer.parseInt(word[5]), Integer.parseInt(word[4]) - 1, Integer.parseInt(word[3]));
                Date birthDate = calendar.getTime();

                return new Person(firstName, middleName, lastName, birthDate);
            }
            return  null;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
