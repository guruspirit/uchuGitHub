package com.javarush.task.task10.task1003;

/* 
Задача №3 на преобразование целых типов
*/

public class Solution {
    public static void main(String[] args) {
        float f = (float) 128.50; //-128.0
        int i = (byte) f;       //short to char
        int b = (int) (i +(char)f); //target b=0
        System.out.println(b);
    }
}
