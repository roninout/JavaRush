package com.javarush.task.task06.task0609;

/* 
Расстояние между двумя точками
*/

public class Util {
    public static double getDistance(int x1, int y1, int x2, int y2) {
        //напишите тут ваш код
        //AB = √(xb - xa)2 + (yb - ya)2
        //корень из (х2 - х1)квадрат + (y2- y1)квадрат
        return Math.sqrt((Math.pow((x2 - x1),2))+(Math.pow((y2-y1),2)));
    }

    public static void main(String[] args) {

    }
}
