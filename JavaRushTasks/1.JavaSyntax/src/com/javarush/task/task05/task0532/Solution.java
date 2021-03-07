package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum;
        int next;
        int count=Integer.parseInt(reader.readLine());
        if (count>0) {
            //maximum = Integer.parseInt(reader.readLine());//maximum=count;
            maximum = Integer.parseInt(reader.readLine());

            for (int i = 0; i < count-1; i++) {
                next = Integer.parseInt(reader.readLine());
                //maximum = (maximum > next ? maximum : next);

                if(maximum<next)
                    maximum=next;
            }
            //напишите тут ваш код

            System.out.println(maximum);
        }
    }
}
