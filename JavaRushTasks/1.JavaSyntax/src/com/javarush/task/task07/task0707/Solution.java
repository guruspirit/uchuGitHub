package com.javarush.task.task07.task0707;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.*;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        list.add("Hello");
        list.add("hi");
        list.add("how are you");
        list.add("I'm fine");
        list.add("Thank you");

        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));

        }

    }
}
