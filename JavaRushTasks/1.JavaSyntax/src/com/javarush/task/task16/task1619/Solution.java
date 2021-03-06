package com.javarush.task.task16.task1619;

public class Solution {
    public static volatile boolean interrupt = false;
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new TestThread());
        t.start();
        Thread.sleep(3000);
        ourInterruptMethod();
    }
    public static void ourInterruptMethod(){
        interrupt=true;
    }
    public static class TestThread implements Runnable{

        @Override
        public void run() {
            while (!interrupt){
                try{
                    System.out.println("he-he");
                    Thread.sleep(500);
                } catch (InterruptedException e){}
            }
        }
    }
}
