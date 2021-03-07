package com.javarush.task.task10.task1015;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args){
        ArrayList<String> [] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

     static void printList(ArrayList<String>[] arrayOfStringList) {
        for(ArrayList<String> list: arrayOfStringList){
            for(String string: list){
                System.out.println(string);
            }
        }
    }

    public static ArrayList<String>[] createList() {
        ArrayList<String> [] arrayOfStringList = new ArrayList[10];
        ArrayList<String> aList = new ArrayList<>();
        aList.add("Hello world!");
        for (int i = 0; i < 10; i++) {
            arrayOfStringList[i]=aList;
        }

        return arrayOfStringList;
    }

}
