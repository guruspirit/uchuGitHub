package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int [] num20 = new int[20];
        int [] num1 = new int[10];
        int [] num2 = new int[10];
        for (int i = 0; i < 20; i++) {
            num20[i]= Integer.parseInt(reader.readLine());
        }
        for (int i = 0; i < 10; i++) {
            num1[i]=num20[i];
            num2[i]=num20[i+10];
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(num2[i]);
        }
    }
}
