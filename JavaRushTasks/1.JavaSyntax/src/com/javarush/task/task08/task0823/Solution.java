package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        char[] ch = string.toCharArray();
        ch[0]=Character.toUpperCase(ch[0]);
        for (int i = 1; i < ch.length; i++) {
            if(ch[i-1]== ' ')
                ch[i]=Character.toUpperCase(ch[i]);
        }
        for (int i = 0; i < ch.length; i++) {
            System.out.print(ch[i]);
        }
        //напишите тут ваш код
    }
}
