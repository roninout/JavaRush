package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public int hashCode() {
        int result;
        result = first == null ? 0 : first.hashCode();
        result = last == null ? 31 * result : 31 * result + last.hashCode();
        return result;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Solution))
            return false;
        Solution n = (Solution) o;
        return n.first == first && n.last == last;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
