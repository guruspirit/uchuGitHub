package com.javarush.task.task09.task0906;

/* 
Логирование стек-трейса
*/

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        //напишите тут ваш код
        StackTraceElement[] stackTraceElements= Thread.currentThread().getStackTrace();
        String x= stackTraceElements[2].getClassName();
        String y= stackTraceElements[2].getMethodName();
        System.out.println(x+": "+y+ ": "+s);
    }
}
