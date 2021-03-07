package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int [] m = new int[10];
        for (int i = 0; i < 10; i++) {
            m[i]=Integer.parseInt(reader.readLine());
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(m[9-i]);
        }
    }
}

