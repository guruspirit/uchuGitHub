package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        try(RandomAccessFile raf = new RandomAccessFile(args[0],"rw")) {
            long number = Long.parseLong(args[1]);
            String text = args[2];

            int size = text.length();
            byte[] b = new byte[size];
            raf.seek(number);

            raf.read(b, 0, size);
            String str = new String(b);
            raf.seek(raf.length());
            if (text.equals(str))
                raf.write("true".getBytes());
            else
                raf.write("false".getBytes());
            System.out.println(b);
        }

    }
}
