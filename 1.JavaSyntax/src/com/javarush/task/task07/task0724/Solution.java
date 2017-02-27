package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human ded1 = new Human("ded1", true, 58);
        System.out.println(ded1);

        Human ded2 = new Human("ded2", true, 59);
        System.out.println(ded2);

        Human bab1 = new Human("bab1", false, 58);
        System.out.println(bab1);

        Human bab2 = new Human("bab2", false, 59);
        System.out.println(bab2);

        Human pap = new Human("pap", true, 38, ded1, bab1);
        System.out.println(pap);

        Human mam = new Human("mam", false, 35, ded2, bab2);
        System.out.println(mam);

        Human san1 = new Human("san1", true, 18, pap, mam);
        System.out.println(san1);

        Human san2 = new Human("san2", true, 19, pap, mam);
        System.out.println(san2);

        Human dot = new Human("dot", false, 12, pap, mam);
        System.out.println(dot);
    }

    public static class Human {
        //напишите тут ваш код
        public String name;
        public boolean sex;
        public int age;
        public Human father;
        public Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















