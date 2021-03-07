package com.javarush.task.task09.task0903;

/* 
Кто меня вызывал?
*/

public class Solution {
    public static void main(String[] args) {
        method1();
    }

    public static int method1() {
        method2();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        int x=stackTraceElements[2].getLineNumber();
        return  x;
    }

    public static int method2() {
        method3();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        int x=stackTraceElements[2].getLineNumber();
        return  x;
    }

    public static int method3() {
        method4();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        int x=stackTraceElements[2].getLineNumber();
        return  x;    }

    public static int method4() {
        method5();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        int x=stackTraceElements[2].getLineNumber();
        return  x;
    }

    public static int method5() {

        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        int x=stackTraceElements[2].getLineNumber();
        return  x;
    }
}
