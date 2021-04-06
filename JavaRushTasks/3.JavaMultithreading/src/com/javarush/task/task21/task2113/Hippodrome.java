package com.javarush.task.task21.task2113;

import java.util.*;

public class Hippodrome {
    static Hippodrome game;
    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move(){
        for(Horse h: horses){
            h.move();
        }
    }
    public void print(){
        for (Horse h: horses){
            h.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    public Horse getWinner(){
        double winnerDistance=0;
        Horse winner=null;
        for(Horse currentHorse: horses){
            if(currentHorse.distance>winnerDistance){
                winnerDistance=currentHorse.distance;
                winner = currentHorse;
            }
        }
        return winner;
    }
    public void printWinner(){
        System.out.println("Winner is "+getWinner().getName()+"!");
    }
    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = new ArrayList<>();
        Horse h1 = new Horse("Sivka",3,0);
        Horse h2 = new Horse("Burka",3,0);
        Horse h3 = new Horse("Kaurka",3,0);
        horses.add(h1);
        horses.add(h2);
        horses.add(h3);
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }
}
