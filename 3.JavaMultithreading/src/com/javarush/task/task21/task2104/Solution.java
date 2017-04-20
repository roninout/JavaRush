package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode

не принимает коменты при валидации
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public int hashCode() {
        int result;
        result = first == null ? 0 : first.hashCode();
        result = last == null ? 31 * result : 31 * result + last.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) // Если обьект один - true
            return true;
        if (obj == null) // Если переданный для сравнения объект – null, то объекты не равны. Объект, у которого вызвали метод equals ведь точно не null.
            return false;
        if (obj.getClass() != this.getClass()) // Если объекты разных классов, то мы не будем пробовать их сравнить, а сразу говорим, что это различные объекты – return false.
            return false;

        Solution other = (Solution) obj;
        if (!(obj instanceof Solution)) return false; // --------------  костыль ----------

        if (first != other.first)
            return false;
        if (last != other.last)
            return false;
        return true;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}


/*

http://www.seostella.com/ru/article/2012/10/04/kak-sgenerirovat-hashcode-v-java.html

Следуйте следующим общепринятым правилам при переопределении метода hashCode():

1. Присвойте результирующей переменной (result) некоторое ненулевое простое число (например, 17)
2. Если поле value имеет тип boolean, вычислите (value ? О : 1)
3. Если поле value имеет тип byte, char, short или int, вычислите (int)value
4. Если поле value имеет тип long, вычислите (int)(value - (value >>> 32))
5. Если поле value имеет тип float, вычислите Float.floatToIntBits(value)
6. Если поле value имеет тип double, вычислите Double.doubleToLongBits(value), а затем преобразуйте полученное значение, как указано в п.4
7. Если поле value является ссылкой на объект, вызывайте метод hashCode() этого объекта
8. Если поле value является ссылкой на объект и равно null, используйте число 0 для представления его хэш-кода
9. Объедините полученные в п. 2 - п. 8 значения следующим образом: 37*result + value
10. Если поле является массивом, примените правило 9 для каждого элемента массива
11. Проверьте, что равные объекты возвращают одинаковый hashCode
 */

/*
public class TestClass {
    private boolean booleanValue = true;
    private char charValue = 'd';
    private String stringValue = "TestClass";
    private long longValue = 34829245849498300l;
    private float floatValue = 345832400.93f;
    private double doubleValue = 98584292348454.9834;
    private byte[] arrayValue = {1, 2, 3};

    @Override
    public int hashCode() {
        int result = 17;

        result = 37 * result + ( booleanValue ? 1 : 0 );
        result = 37 * result + (int) charValue;
        result = 37 * result + (stringValue == null ? 0 : stringValue.hashCode());
        result = 37 * result + (int)(longValue - (longValue >>> 32));
        result = 37 * result + Float.floatToIntBits(floatValue);
        long longBits = Double.doubleToLongBits(doubleValue);
        result = 37 * result + (int)(longBits - (longBits >>> 32));
        for( byte b : arrayValue )
            result = 37 * result + (int) b;

        return result;
    }

}
 */