package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        ArrayList<Integer> listOther = new ArrayList<Integer>();
        //Collections.addAll(list,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
        for (int i = 0; i < 20; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }
        for (int i = 0; i < 20; i++) {
            if(list.get(i)%3==0)
                list3.add(list.get(i));
        }
        for (int i = 0; i < 20; i++) {
            if(list.get(i)%2==0)
                list2.add(list.get(i));
        }
        for (int i = 0; i < 20; i++) {
            if((list.get(i)%2!=0)&&(list.get(i)%3!=0))
                listOther.add(list.get(i));
        }
        printList(list3);
        printList(list2);
        printList(listOther);

    }

    public static void printList(ArrayList<Integer> list) {
        //напишите тут ваш код
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
