package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String > list = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
            list.add(reader.readLine());
        int curr,prev=list.get(0).length(); //prev - длина предыдущего элемента
        for (int i = 1; i < list.size(); i++) {
            curr=list.get(i).length();   //cur - длина текущего элемента
            //System.out.println(prev+" / / "+curr);
            if(curr<prev) {
                System.out.println(i);
                break;
            }
            prev=curr;
        }
    }
}

