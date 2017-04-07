package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

// ------------- XOR ------------
// 0 xor 0 = 0
// 0 xor 1 = 1
// 1 xor 0 = 1
// 1 xor 1 = 0

// (a ^ b) ^ b = a


// при записи в файл, не запусть про перевод на новую строку

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        if (args.length != 3) return;
        String fileName = args[args.length - 2];
        String fileOutputName = args[args.length - 1];
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        FileWriter writer = new FileWriter(fileOutputName);

        String result, key = "y";

        switch (args[0]) {
            case "-e":
                while ((result = br.readLine()) != null)
                {
                    writer.write(new String(Encrypt(result, key)));
                    writer.write(System.getProperty("line.separator"));
                }
                break;
            case "-d":
                while ((result = br.readLine()) != null)
                {
                    writer.write(Decrypt(result.getBytes(), key));
                    writer.write(System.getProperty("line.separator"));
                }
                break;
            default:
                System.out.println("Введен не корректный параметр");
                break;
        }
        br.close();
        writer.close();
    }

    // шифрования строки
    public static byte[] Encrypt(String pText, String pKey)
    {
        byte[] txt = pText.getBytes();
        byte[] key = pKey.getBytes();
        byte[] res = new byte[pText.length()];

        for (int i = 0; i < txt.length; i++)
            res[i] = (byte) (txt[i] ^ key[i % key.length]);

        return res;
    }

    // дешифрования строки
    public static String Decrypt(byte[] pText, String pKey) {
        byte[] res = new byte[pText.length];
        byte[] key = pKey.getBytes();

        for (int i = 0; i < pText.length; i++) {
            res[i] = (byte) (pText[i] ^ key[i % key.length]);
        }

        return new String(res);
    }

}
