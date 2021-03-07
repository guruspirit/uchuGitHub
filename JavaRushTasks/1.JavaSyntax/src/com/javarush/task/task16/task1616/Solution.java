package com.javarush.task.task16.task1616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        reader.readLine();
        stopWatch.interrupt();
        reader.close();
        in.close();

    }
    public static class StopWatch extends Thread{
        private volatile int seconds=0;
        @Override
        public void run(){
            try{
                while (!isInterrupted()) {
                    Thread.sleep(1000);
                    seconds++;
                }
            } catch (InterruptedException e){
                System.out.println(seconds);
            }
        }
    }
}
