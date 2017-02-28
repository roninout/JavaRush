package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human child1 = new Human("child1", true, 3, new ArrayList<Human>());
        Human child2 = new Human("child2", false, 5, new ArrayList<Human>());
        Human child3 = new Human("child3", true, 8, new ArrayList<Human>());

        ArrayList<Human> children = new ArrayList<>();
        children.add(child1);
        children.add(child2);
        children.add(child3);

        Human pap = new Human("pap", true, 30, children);
        ArrayList<Human> papchildren = new ArrayList<>();
        papchildren.add(pap);

        Human mam = new Human("mam", false, 28, children);
        ArrayList<Human> mamchildren = new ArrayList<>();
        mamchildren.add(mam);

        Human ded1 = new Human("ded1", true, 76, papchildren);
        Human ded2 = new Human("ded2", true, 78, mamchildren);
        Human bab1 = new Human("bab1", false, 76, papchildren);
        Human bab2 = new Human("bab2", false, 78, mamchildren);

        System.out.println(ded1.toString());
        System.out.println(ded2.toString());
        System.out.println(bab1.toString());
        System.out.println(bab2.toString());
        System.out.println(pap.toString());
        System.out.println(mam.toString());
        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());
    }

    public static class Human {
        //напишите тут ваш код
        public String name;
        public boolean sex;
        public int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
