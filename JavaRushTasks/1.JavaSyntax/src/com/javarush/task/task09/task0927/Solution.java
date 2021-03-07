package com.javarush.task.task09.task0927;
import java.util.*;

/*
Десять котов
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        Map<String,Cat> myMapCat = new HashMap<String, Cat>();
        myMapCat.put("Басик1", new Cat("Басик1"));
        myMapCat.put("Басик2", new Cat("Басик2"));
        myMapCat.put("Басик3", new Cat("Басик3"));
        myMapCat.put("Басик4", new Cat("Басик4"));
        myMapCat.put("Басик5", new Cat("Басик5"));
        myMapCat.put("Басик6", new Cat("Басик6"));
        myMapCat.put("Басик7", new Cat("Басик7"));
        myMapCat.put("Басик8", new Cat("Басик8"));
        myMapCat.put("Басик9", new Cat("Басик9"));
        myMapCat.put("Басик10", new Cat("Басик10"));
        return myMapCat;
    }


    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        Set<Cat> myCats = new HashSet<>(map.values());
        return myCats;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
