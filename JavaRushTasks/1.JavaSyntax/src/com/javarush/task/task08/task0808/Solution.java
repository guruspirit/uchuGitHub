package com.javarush.task.task08.task0808;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* 
10 тысяч удалений и вставок
*/

public class Solution {
    public static void main(String[] args) {
        // ArrayList
        Date t1 = new Date();
        ArrayList arrayList = new ArrayList();
        insert10000(arrayList);
        Date t2 = new Date();
        get10000(arrayList);
        Date t3 = new Date();
        set10000(arrayList);
        Date t4 = new Date();
        remove10000(arrayList);
        Date t5 = new Date();
        System.out.println("ArrayList: ins, get, set, remove");
        System.out.println((t2.getTime()-t1.getTime())+" "+(t3.getTime()-t2.getTime())+" "+(t4.getTime()-t3.getTime())+" "+(t5.getTime()-t4.getTime()));
        // LinkedList
        LinkedList linkedList = new LinkedList();
        Date l1 = new Date();
        insert10000(linkedList);
        Date l2 = new Date();
        get10000(linkedList);
        Date l3 = new Date();
        set10000(linkedList);
        Date l4 = new Date();
        remove10000(linkedList);
        Date l5 = new Date();
        System.out.println("LinkedList: ins, get, set, remove");
        System.out.println((l2.getTime()-l1.getTime())+" "+(l3.getTime()-l2.getTime())+" "+(l4.getTime()-l3.getTime())+" "+(l5.getTime()-l4.getTime()));
    }

    public static void insert10000(List list) {
        //напишите тут ваш код
        for (int i = 0; i < 10000; i++) {
            list.add(0,i);
        }

    }

    public static void get10000(List list) {
        //напишите тут ваш код
        for (int i = 0; i < 10000; i++) {
            list.get(i);
        }
    }

    public static void set10000(List list) {
        //напишите тут ваш код
        for (int i = 0; i < 10000; i++) {
            list.set(0,i);
        }
    }

    public static void remove10000(List list) {
        //напишите тут ваш код
        for (int i = 0; i < 10000; i++) {
            list.remove(0);
        }
    }
}
