package com.javarush.task.task09.task0924;
import java.util.ArrayList;
/* 
Страшная сказка
*/
public class Solution {
    public static LittleRedRidingHood hood = new LittleRedRidingHood(); //красная шапочка
    public static Grandmother grandmother = new Grandmother();          //бабушка
    public static Patty patty = new Patty();                            //пирожок
    public static Woodman woodman = new Woodman();                      //дровосек
    public static Wolf wolf = new Wolf();                               //волк

    public static void main(String[] args) {
        // напишите тут ваш код
        wolf.ate.add(new Grandmother());
        wolf.ate.add(new LittleRedRidingHood());
        woodman.killed.add(new Wolf());
    }

    // Красная шапочка
    public static class LittleRedRidingHood extends StoryItem {
    }

    // Бабушка
    public static class Grandmother extends StoryItem {
    }

    // Пирожок
    public static class Patty extends StoryItem {
    }

    // Дровосек
    public static class Woodman extends StoryItem { //расширяет StoryItem сюжетный элемент
    }

    // Волк
    public static class Wolf extends StoryItem {
    }

    public static abstract class StoryItem {
        public ArrayList<StoryItem> killed = new ArrayList<>();
        public ArrayList<StoryItem> ate = new ArrayList<>();
    }
}
