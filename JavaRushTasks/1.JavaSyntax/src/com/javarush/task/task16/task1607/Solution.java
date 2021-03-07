package com.javarush.task.task16.task1607;
import java.util.ArrayList;
import java.util.List;
/*
Horse Racing
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = prepareHorsesAndStart(10);
        while (calculateHorsesFinished(horses) != horses.size()) {
        }
    }
    public static int calculateHorsesFinished(List<Horse> horses) throws InterruptedException {
        int finishedCount = 0;
        //напишите тут ваш код
        for(Horse horse: horses){
            if(!horse.isFinished()){
                System.out.println("Waiting for " + horse.getName());
                horse.join();
            }
            else{
                ++finishedCount; // плюс одна лошадь финишировала
            }
        }
        return finishedCount;  // возвращаем в main количество финишировавших лошадей
    }
    public static List<Horse> prepareHorsesAndStart(int horseCount) {
        List<Horse> horses = new ArrayList<>(horseCount);
        String number;
        for (int i = 1; i < horseCount + 1; i++) {
            number = i < 10 ? ("0" + i) : "" + i;
            horses.add(new Horse("Horse_" + number));
        }
        for (int i = 0; i < horseCount; i++) {
            horses.get(i).start();
        }
        return horses;
    }
    public static class Horse extends Thread {
        private boolean isFinished;
        private String horseTrace="";

        public void setHorseTrace(String trace) {
            this.horseTrace = trace;
        }

        public String getTrace() {
            return horseTrace;
        }

        public Horse(String name) {
            super(name);
        }
        public boolean isFinished() {
            return isFinished;
        }
        public void run() {
            String s = "";
            for (int i = 0; i < 100001; i++) {   // Delay
                s = i + " " + s;
                setHorseTrace(s);
                if (i == 100000) {
                    s = " has finished the race!";
                    System.out.println(getName() + s);
                    isFinished = true;  // лошадь финишировала
                }
            }
        }
    }
}