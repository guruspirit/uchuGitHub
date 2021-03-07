package com.javarush.task.task16.task1602;

public class Solution {
    public static void main(String[] args) {
        TestThread thread = new TestThread();
        thread.start();
    }
    public static class TestThread extends Thread{
        static {
            System.out.println("It's a static block inside TestThread");
        }
        public void run(){
            System.out.println("It's a run method");
        }
    }
}
