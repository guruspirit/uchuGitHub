package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        double sum=1;
        int x=0,i=-1;
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        do{
            x=Integer.parseInt(reader.readLine());
            i++;
            sum+=x;

        }while (x!=-1);
        sum/=i;
        System.out.println(sum);
    }
}

