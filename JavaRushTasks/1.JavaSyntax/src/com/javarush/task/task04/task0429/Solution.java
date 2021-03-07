package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int pcount=0, ncount=0;
        if (a>0)
            pcount++;
        else if (a<0)
            ncount++;
        if (b>0)
            pcount++;
        else if (b<0)
            ncount++;
        if (c>0)
            pcount++;
        else if (c<0)
            ncount++;
        System.out.println("количество отрицательных чисел: "+ncount);
        System.out.println("количество положительных чисел: "+pcount);
    }
}
