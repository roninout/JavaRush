package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики 1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static
    {
        labels.put(23.6, "aaa");
        labels.put(33.0, "bbb");
        labels.put(43.6, "ccc");
        labels.put(53.0, "ddd");
        labels.put(63.6, "eee");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
