package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static{
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        Thread3 thread3 = new Thread3();
        Thread4 thread4 = new Thread4();
        Thread5 thread5 = new Thread5();
        threads.add(thread1);
        threads.add(thread2);
        threads.add(thread3);
        threads.add(thread4);
        threads.add(thread5);
    }
    public static void main(String[] args) {
        threads.get(2).start();


    }
    static class Thread1 extends Thread{
        public void run(){
            while(true){            }
        }
    }
    static class Thread2 extends Thread{
        public void run(){
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                System.out.println("InterruptedException");
            }
        }
    }
    static class Thread3 extends Thread{
        public void run(){
                try {
                    while (true) {
                        System.out.println("Ура");
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {
            }
        }
    }
    static class Thread4 extends Thread implements Message{
        @Override
        public void run() {
            while (!isInterrupted()){

            }

        }

        @Override
        public void showWarning() {
            interrupt();
        }
    }
    static class Thread5 extends Thread{
        public void run(){
            int sum = 0;
            String str="";
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try{
                while (true) {
                    str = reader.readLine();
                    sum += Integer.parseInt(str);
                }
            } catch (IOException e){

            } catch (NumberFormatException e)
            {
                if(str.equals("N"))
                    System.out.println(sum);
            }
        }
    }
}
