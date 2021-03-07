package com.javarush.task.task04.task0439;

/* 
Письмо счастья
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s=reader.readLine();
        for (int j = 0; j < 10; j++)
            System.out.println(s+" любит меня.");
    }
}
