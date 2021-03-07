package com.javarush.task.task10.task1020;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
Задача по алгоритмам Ӏ Java Syntax: 10 уровень, 11 лекция
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[30];//{5,10,16,17,9,3,4,46,97,12,45,42,98,98,71,-123,-85,-16,-17,-9,-3,-4,-46,-97,-12,-45,-42,918,-98,71};/*
        for (int i = 0; i < 30; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }
        sort(array);
        System.out.println(array[9]);
        System.out.println(array[10]);
    }
    public static void sort(int[] array) {
        //напишите тут ваш код
        int tmp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1; j++) {
                if(array[j]>array[j+1]){
                    tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                }

            }
        }
    }
}