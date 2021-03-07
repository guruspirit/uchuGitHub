package com.javarush.task.task16.task1623;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int count = 15;
    static volatile int createdThreadCount;

    static {
        createdThreadCount = 0;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        //System.out.println(new GenerateThread());
        System.out.println(new GenerateThread());
    }
    public static class GenerateThread extends Thread{
        public GenerateThread() {
            super((++createdThreadCount)+"");
            start();
        }
        public void run(){
            if(createdThreadCount<count)
                System.out.println(new GenerateThread());
        }

        @Override
        public String toString() {
            return getName() + " created";
        }
    }
}
