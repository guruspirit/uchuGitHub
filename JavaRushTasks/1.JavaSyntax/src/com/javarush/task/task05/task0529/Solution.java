package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int sum=0;
        String input;
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));

        while (true){
            input=reader.readLine();
            if (input.equals("сумма"))
                break;
            sum+=Integer.parseInt(input);
        }
        System.out.println(sum);
    }
}
