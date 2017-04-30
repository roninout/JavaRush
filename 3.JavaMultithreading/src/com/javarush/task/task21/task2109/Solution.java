package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            if (this.getName() != null)
                return new C(this.getI(), this.getJ(), this.getName());
            else
                return new C(this.getI(), this.getJ(), null);
        }
    }

    public static void main(String[] args) {

        A a = new A(1,2);
        B b = new B(1,2, "хаха");
        C c = new C(3,4,"bbbb");
        A cloneA = null;
        //B cloneB = null;
        C cloneC = null;
        try {cloneA = (A)a.clone();}
        catch (CloneNotSupportedException e) {e.printStackTrace();}

        //try {cloneB = (B)b.clone();}
        //catch (CloneNotSupportedException e) {e.printStackTrace();}

        try {cloneC = (C)c.clone();}
        catch (CloneNotSupportedException e) {e.printStackTrace();}

        System.out.println(a);
        System.out.println(cloneA);

        System.out.println(b);
        //System.out.println(cloneB);

        System.out.println(c);
        System.out.println(cloneC);
    }
}
