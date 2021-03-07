package com.javarush.task.task08.task0819;

import java.util.*;

/* 
Set из котов
*/
// my
        /*
        Map<String, String> map =new HashMap<String, String>();
        map.put("one","Один");
        map.put("two","Два");
        map.put("three","Три");

        Iterator<Map.Entry<String, String>> iterator1 = map.entrySet().iterator();
        while(iterator1.hasNext()){
            Map.Entry<String, String> pair = iterator1.next();
            String key = pair.getKey();
            String val = pair.getValue();
            System.out.println(key+" "+val);
        }
        for(Map.Entry<String, String> pair2: map.entrySet())
            System.out.println(pair2.getKey()+" "+pair2.getValue());
*/
/*

        Set<String> set = new HashSet<String>();
        set.add("1");
        set.add("Rama");
        set.add("Ramа");
        set.add("mila");
        set.add("ramu");
        set.add("pochemu");

        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext())
        {
            String s = iterator.next();
            System.out.println(s);
        }

        for(String s1: set)
            System.out.println(s1);
        */

public class Solution {
    public static void main(String[] args) {

        Set<Cat> cats = createCats();
        //напишите тут ваш код. step 3 - пункт 3
        printCats(cats);
        for(Cat cat1: cats){
            cats.remove(cat1);
            break;
        }
    }

    public static Set<Cat> createCats() {       //2
        //напишите тут ваш код. step 2 - пункт 2
        Set<Cat> cats = new HashSet<Cat>();
        cats.add(new Cat());
        cats.add(new Cat());
        cats.add(new Cat());
        return cats;
    }

    public static void printCats(Set<Cat> cats) {
        // step 4 - пункт 4
        for(Cat tCats: cats)
            System.out.println(tCats);

    }
    // step 1 - пункт 1
    public static class Cat{
//        String name;
        public Cat(){

        }
  /*      public Cat(String name){
            this.name=name;
        }
        String getName(){
            return  name;
        }
  */
        //public void add(String name this.name=name;}
    }
}