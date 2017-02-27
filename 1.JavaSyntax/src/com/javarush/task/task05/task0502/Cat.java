package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        //напишите тут ваш код
        int points = 0;
        if (this.weight > anotherCat.weight) points++;
        if (this.strength > anotherCat.strength) points++;
        if (this.age > anotherCat.age) points--;

        return points > 0;
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.age = 2;
        cat1.weight = 3;
        cat1.strength = 4;

        Cat cat2 = new Cat();
        cat2.age = 3;
        cat2.weight = 2;
        cat2.strength = 3;

        System.out.println(cat1.fight(cat2));
    }
}
