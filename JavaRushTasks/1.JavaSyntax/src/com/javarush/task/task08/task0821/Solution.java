package com.javarush.task.task08.task0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap() {
        //напишите тут ваш код
        /*
        Map<String, String>  ppl = new HashMap<String, String>();
        String f,n;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Введите Фамилию " + (i + 1) + ": ");
                f = reader.readLine();
                System.out.println("Введите Имя " + (i + 1) + ": ");
                n = reader.readLine();
                ppl.put(f, n);
            }
        }


        catch (IOException e){}*/
        Map<String, String>  ppl = new HashMap<String, String>();
        ppl.put("A", "A");
        ppl.put("A", "A");
        ppl.put("B", "B");
        ppl.put("B", "B");
        ppl.put("B", "B");
        ppl.put("B", "B");
        ppl.put("B", "B");
        ppl.put("B", "B");
        ppl.put("B", "B");
        ppl.put("B", "B");
        return ppl;
    }

    public static void printPeopleMap(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
