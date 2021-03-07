package com.javarush.task.task09.task0928;

/* 
Код не компилится…
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sourceFileName = reader.readLine();
        String destinationFileName = reader.readLine();

        InputStream fileInputStream = getInputStream(sourceFileName); //читаем отсюда
        OutputStream fileOutputStream = getOutputStream(destinationFileName); //сюда пишем

        int count = 0;
        while (fileInputStream.available() > 0)  //пока доступен файл чтения
        {
            int data = fileInputStream.read(); //читаем файл в data
            fileOutputStream.write(data); //пишем в файл
            count++;
        }

        System.out.println("Скопировано байт " + count);

        fileInputStream.close();
        fileOutputStream.close();
    }

    public static InputStream getInputStream(String fileName) throws IOException {
        return new FileInputStream(fileName);
    }

    public static OutputStream getOutputStream(String fileName) throws IOException {
        return new FileOutputStream(fileName);
    }
}
