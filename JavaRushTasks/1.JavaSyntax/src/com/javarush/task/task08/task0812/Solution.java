package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }
        int max=0;
        int prev=0; //previous
        int length=0;
        for (int i = 0; i < list.size(); i++) { // (1,1,2,3,4,5,6,6,6,6)
            if (i == 0) {
                prev = list.get(i);
                length++;
                continue;
            }
            if (prev == list.get(i)) {
                length++;
            } else {
                if(max<length)max=length;
          //      res.add(length);  // закомментировать
                prev = list.get(i);
                length = 1;
            }
        }
        //res.add(length);  //  закомментировать
        if(max<length)max=length;

            /*for (int j = 0; j < res.size(); j++) {
                System.out.print(res.get(j));
            }*/
        System.out.println(max);
        //System.out.println(max);
    }
}