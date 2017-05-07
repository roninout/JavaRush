package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args){

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine())))
        {
            ArrayList<String> words = new ArrayList<>(); // коллекция всех слов
            ArrayList<Integer> findedIds = new ArrayList<>(); // коллекция индексов найденных слов

            while (fileReader.ready()) // считываем файл
            {
                String[] array = fileReader.readLine().split(" "); // строки в файле
                Collections.addAll(words, array); // добавляем их в ArrayList
            }

            for (int i = 0; i < words.size(); i++) // пробегаем по словам
            {
                if (findedIds.contains(i)) continue; // пропсукаем индекс найденного реверсивного слова (впереди текущего)

                for (int j = i+1; j < words.size(); j++) // пробегаем по словам + 1
                {
                    StringBuilder str2 = new StringBuilder(words.get(j)).reverse();

                    if (words.get(i).equals(str2.toString())){ // если равны, добавляем в класс
                        Pair pair = new Pair();
                        pair.first  = words.get(i);
                        pair.second = words.get(j);
                        result.add(pair);
                        findedIds.add(j); // запоминаем индекс найденного реверсивного слова
                        break;
                    }
                }
            }

            for (Pair list: result)
                System.out.println(list.toString());
        }
        catch (IOException e) { e.printStackTrace(); }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
