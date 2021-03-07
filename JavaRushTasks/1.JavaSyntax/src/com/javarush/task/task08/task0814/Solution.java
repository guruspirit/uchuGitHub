package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        // напишите тут ваш код
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < 20; i++) {
            set.add(i+1);
        }

        return set;
    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        // напишите тут ваш код
        Set<Integer> tset = new HashSet<>();
        for(int x: set)
            if (x > 10)
                tset.add(x);
        set.removeAll(tset);
        return set;
    }

    public static void main(String[] args) {
        /*Set<Integer> mySet1 = createSet();
        Set<Integer> mySet2 = removeAllNumbersGreaterThan10(mySet1);
        for(int i: mySet1)
            System.out.print(i+" ");
        for(int i: mySet2)
            System.out.print(i+" ");*/
    }
}
