package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String word=reader.readLine();
            if(word.equals("end")) break;
            else
                list.add(word);
        }
        for(String s: list) System.out.println(s);
        //напишите тут ваш код
    }
}