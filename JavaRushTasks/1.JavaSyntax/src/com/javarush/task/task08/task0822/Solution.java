package com.javarush.task.task08.task0822;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));    //1
    }

    public static int getMinimum(List<Integer> array) {
        // Найти минимум тут            //2
        int min=0;
        for(int a: array)
        {
            min=a;
            break;
        }
        for(int a: array)
        {
            if (a<min)
                min=a;
        }
        return min;
    }

    public static List<Integer> getIntegerList() throws IOException {
        // Создать и заполнить список тут
        List<Integer> array = new ArrayList<Integer>();
        int count =0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.println("Привет. Сколько чисел? ");
            count=Integer.parseInt(reader.readLine());
            System.out.println("Введи "+count+" чисел: ");
            for (int i = 0; i < count; i++) {
                array.add(Integer.parseInt(reader.readLine()));
            }
        }
        catch (Exception e){}

        return array;
    }
}
