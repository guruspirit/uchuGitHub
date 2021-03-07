package com.javarush.task.task09.task0926;
import java.util.ArrayList;
import java.util.Arrays;

/*
Список из массивов чисел
*/
public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код

        int[] a1 = new int[]{1,2,3,4,5};
        int[] a2 = new int[]{1,2};
        int[] a3 = new int[]{1,2,3,4};
        int[] a4 = new int[]{1,2,3,4,5,6,7};
        int[] a5 = new int[]{};
        ArrayList<int[]> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        list.add(a5);
        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
