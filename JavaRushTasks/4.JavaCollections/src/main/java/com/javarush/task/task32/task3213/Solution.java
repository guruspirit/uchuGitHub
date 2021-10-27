package com.javarush.task.task32.task3213;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //эту строку должен будет прочитать Reader
        String test = "Hi!\n My name is Richard\n I'm a photographer\n";
        //заворачиваем строку в StringReader
        StringReader reader = new StringReader(test);

        //Создаем объект StringWriter
        StringWriter writer = new StringWriter();

        //переписываем строки из Reader во Writer, предварительно развернув их
        executor(reader, writer);

        //получаем текст, который был записан во Writer
        String result = writer.toString();

        //выводем полученный из Writer’а текст на экран
        System.out.println("Результат: " + result);
    }

    public static void executor(Reader reader, Writer writer) throws Exception {
        BufferedReader br = new BufferedReader(reader);
        String line;

        //читаем строку из Reader’а

        while ((line = br.readLine()) != null) {
            //разворачиваем строку задом наперед
            StringBuilder sb = new StringBuilder(line);
            String newLine = sb.reverse().toString();

            //пишем строку в Writer
            writer.write(newLine);
        }
    }
}

/* 
Шифр Цезаря
*/
/*
public class Solution {
    public static void main(String[] args) throws IOException {
        Integer a = 1;
        plus100(a);
        System.out.println(a.toString());
        /*StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }
    static void plus100(Integer a) {
        a+=100;
    }

    public static String decode(StringReader reader, int key) throws IOException {
        try {
            StringWriter stringWriter = new StringWriter();
            BufferedReader bufferedReader = new BufferedReader(reader);
            int chr;
            while ((chr = bufferedReader.read()) != -1) {
                stringWriter.write(chr + key);
            }
            return stringWriter.toString();
        } catch (NullPointerException e) {
            return "";
        }
    }
}
*/