package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int a = Integer.parseInt(reader.readLine());
            int b = Integer.parseInt(reader.readLine());

            if(a <= 0 || b <= 0){
                throw new Exception();
            }

            int result = 0;

            while (a != 0 && b != 0) {
                if (a > b)
                    a = a % b;
                else
                    b = b % a;
                result = a + b;
            }
            System.out.println(result);
    }
}
