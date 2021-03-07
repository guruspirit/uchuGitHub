package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        int a1,a2,a3,a4,a5,t;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        a1=Integer.parseInt(reader.readLine());
        a2=Integer.parseInt(reader.readLine());
        a3=Integer.parseInt(reader.readLine());
        a4=Integer.parseInt(reader.readLine());
        a5=Integer.parseInt(reader.readLine());
        for(int i=0;i<5;i++){
            if (a1>a2) {
                t=a1;
                a1=a2;
                a2=t;
            }
            if (a2>a3) {
                t=a2;
                a2=a3;
                a3=t;
            }
            if (a3>a4) {
                t=a3;
                a3=a4;
                a4=t;
            }
            if (a4>a5) {
                t=a4;
                a4=a5;
                a5=t;
            }
        }
        System.out.println(a1+"\n"+a2+"\n"+a3+"\n"+a4+"\n"+a5);


        //напишите тут ваш код
    }
}
