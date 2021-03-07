package com.javarush.task.task16.task1609;

import com.javarush.task.task16.taskPrintSlowly.PrintSlowly;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Mouse mouse1 = new Mouse("#1");
        //mouse1.join();
        Mouse mouse2 = new Mouse("#2");
        //mouse2.join();
        Mouse mouse3 = new Mouse("#3");
        //mouse3.join();
    }
    public static class Mouse extends Thread{
        public Mouse(String name) {
            super(name);
            start();
        }
        public static void eat(){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public void run(){
            try {
                //this.join();
                PrintSlowly.printSlowly(getName() + " is starting to eat");
                eat();
                PrintSlowly.printSlowly(getName() + " has finished eating");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println();

        }
    }
}
