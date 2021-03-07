package com.javarush.task.task16.task1612;

public class Solution {
    public static volatile boolean isStopped = false;
    public static void main(String[] args) throws InterruptedException{
        Runner ivanov = new Runner("Ivanov",4); // 4 шага в секунду
        Runner petrov = new Runner("Petrov", 2); // 2 шага в секунду
        //настарт внимание марш
        ivanov.start();
        petrov.start();
        Thread.sleep(2000);
        isStopped = true;
        //System.out.println(ivanov.getName()+" сделал " + ivanov.g);
        Thread.sleep(1000);
    }
    public static class Stopwatch extends Thread{
        private Runner owner;
        private  int stepNumber;

        public Stopwatch(Runner runner) {
            this.owner = runner;
        }

        public void run(){
            try{
                while (!isStopped)
                    doStep();
            } catch (InterruptedException e){}
        }

        private void doStep() throws InterruptedException{
            stepNumber++;
            //
            Thread.sleep((long)(1d/(owner.getSpeed())*1000));
            System.out.println(owner.getName() + " делает шаг №" + stepNumber + "!");
        }
    }
    public static class Runner{
        Stopwatch stopwatch;
        private String name;
        private int speed;

        public Runner(String name, int speed) {
            this.name = name;
            this.speed = speed;
            this.stopwatch = new Stopwatch(this);
        }
        public String getName() {
            return name;
        }
        public int getSpeed(){
            return speed;
        }
        public void start(){
            stopwatch.start();
        }
    }
}
