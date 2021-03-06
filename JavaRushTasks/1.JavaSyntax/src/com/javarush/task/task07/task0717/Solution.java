package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // Считать строки с консоли и объявить ArrayList list тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        //Collections.addAll(list,"a","b","c","d","e","f","g","h","i","j");
        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }
        ArrayList<String> result = doubleValues(list);

        // Вывести на экран result
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) throws IOException {
        //напишите тут ваш код
        int size=list.size();
        for (int i = 0; i < size; i++)
            list.add(i*2,list.get(i*2));

        return list;
    }
}
