package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);

        System.out.println(getQuery(map));
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder builder = new StringBuilder();

        for (Map.Entry<String, String> anParams : params.entrySet()){
            if (anParams.getKey() != null && anParams.getValue() != null)
                builder.append(anParams.getKey() + " = '" + anParams.getValue() + "' and ");
        }

        if (builder.lastIndexOf(" and") != -1)
            return builder.delete(builder.lastIndexOf(" and"), builder.length()).toString();
        else
            return builder.toString();
    }
}
