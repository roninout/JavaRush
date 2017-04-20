package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable{

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }

    }

    protected Map<String, User> users = new LinkedHashMap();

    @Override
    public int hashCode() {
        return users.hashCode() * 31;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Solution solution = (Solution) obj;
        return users.equals(solution.users);
    }

    @Override
    protected Solution clone() throws CloneNotSupportedException {
        Map<String, User> clonedUsers = new LinkedHashMap();

        for (Map.Entry<String, User> map : users.entrySet())
            clonedUsers.put(map.getKey(), (User)map.getValue().clone());

        Solution clonedSolution = new Solution();
        clonedSolution.users = clonedUsers;

        return clonedSolution;
    }




    public static class User implements Cloneable{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new User(age, name);
        }
    }
}
