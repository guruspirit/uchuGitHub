package com.javarush.task.task16.task1611;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class Solution {
    public static volatile boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException{
        Clock clock = new Clock();
        Thread.sleep(2000);
        isStopped = true;
        clock.join();
        System.out.println("The clock has to be stopped");
        Thread.sleep(2000);
        System.out.println("Double-check");
    }
    public static class Clock extends Thread{
        public Clock() {
            setPriority(MAX_PRIORITY);
            start();
        }
        public void run(){
            try {
                while (!isStopped){
                    printTikTak();
                }
            } catch (InterruptedException e){}
        }
        private void printTikTak() throws InterruptedException{
            //for (int i = 0; i < 2; i++) {
            Thread.sleep(500);
            System.out.println("Tik");
            Thread.sleep(500);
            System.out.println("Tak");
            //}
        }
    }
}
