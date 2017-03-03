package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String name;
        private String profesia;
        private String status;
        private int age;
        private int ves;
        private int rost;

        public Human (String name)
        {
            this.name = name;
        }

        public Human (String name, String profesia)
        {
            this.name = name;
            this.profesia = profesia;
        }

        public Human (String name, String profesia, String status)
        {
            this.name = name;
            this.profesia = profesia;
            this.status = status;
        }

        public Human (String name, String profesia, String status, int age)
        {
            this.name = name;
            this.profesia = profesia;
            this.status = status;
            this.age= age;
        }

        public Human (String name, String profesia, String status, int age, int ves)
        {
            this.name = name;
            this.profesia = profesia;
            this.status = status;
            this.age= age;
            this.ves = ves;
        }

        public Human (String name, String profesia, String status, int age, int ves, int rost)
        {
            this.name = name;
            this.profesia = profesia;
            this.status = status;
            this.age= age;
            this.ves = ves;
            this.rost = rost;
        }

        public Human (String name, String status, int age, int ves, int rost)
        {
            this.name = name;
            this.status = status;
            this.age= age;
            this.ves = ves;
            this.rost = rost;
        }

        public Human (String name, String profesia, int ves, int rost)
        {
            this.name = name;
            this.profesia = profesia;
            this.ves = ves;
            this.rost = rost;
        }

        public Human (String profesia, String status, int age)
        {
            this.profesia = profesia;
            this.status = status;
            this.age= age;
        }

        public Human (int age, int ves, int rost)
        {
            this.age= age;
            this.ves = ves;
            this.rost = rost;
        }
    }
}
