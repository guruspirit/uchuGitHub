package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        int chet=0, nechet=0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int [] home = new int[15];
        for (int i = 0; i < 15; i++) {
            home[i]=Integer.parseInt(reader.readLine());
        }
        for (int i = 0; i < 15; i++) {
            if(i%2==0)
                chet+=home[i];
            else
                nechet+=home[i];
        }

        if (nechet>chet)
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        if (chet>nechet)
            System.out.println("В домах с четными номерами проживает больше жителей.");
    }
}
