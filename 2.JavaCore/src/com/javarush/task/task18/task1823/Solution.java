package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String key = reader.readLine();
            if (key.equals("exit")) break;
            ReadThread thread = new ReadThread(key);
            thread.start();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        private String filename;
        public ReadThread(String fileName) {
            //implement constructor body
            this.filename = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public synchronized void run() {
            Map<Integer, Integer> map = new HashMap<>();
            FileInputStream in1;

            try {
                in1 = new FileInputStream(filename);

                while (in1.available() > 0){
                    int key = in1.read();
                    map.put(key, !map.containsKey(key) ? 1 : map.get(key) + 1);
                }

                int maxRep = 0;
                int findByte = -1;

                for (Map.Entry<Integer, Integer> anMap : map.entrySet())
                {
                    if (anMap.getValue() > maxRep)
                    {
                        maxRep = anMap.getValue();
                        findByte = anMap.getKey();
                    }
                }

                resultMap.put(filename, findByte);
                in1.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
