package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
            list.add(reader.readLine());
        int max=0,min=list.get(0).length(),posOfMin=0,posOfMax=0;
        for (int i = 0; i < 10; i++) {
            if(list.get(i).length()>max){
                posOfMax=i;
                max=list.get(i).length();
            }
            if(list.get(i).length()<min){
                posOfMin=i;
                min=list.get(i).length();
            }
        }
        if(posOfMin<posOfMax)
            System.out.println(list.get(posOfMin));
        else
            System.out.println(list.get(posOfMax));
    }
}
