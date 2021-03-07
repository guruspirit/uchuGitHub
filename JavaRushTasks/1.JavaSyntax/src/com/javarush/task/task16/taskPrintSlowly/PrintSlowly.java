package com.javarush.task.task16.taskPrintSlowly;

public class PrintSlowly extends Thread{
    public static void printSlowly(String str) throws InterruptedException {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i));
            if (str.charAt(i)==' '){
                sleep(400);
            }
            sleep(100);
        }
        System.out.println();
    }
}
