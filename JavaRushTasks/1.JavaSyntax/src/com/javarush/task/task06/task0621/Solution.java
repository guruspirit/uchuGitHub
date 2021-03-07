package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandpaName= reader.readLine();
        Cat catGrandpa = new Cat(grandpaName);

        String grandmaName = reader.readLine();
        Cat catGrandma = new Cat(grandmaName);

        String dadName = reader.readLine();
        Cat catDad = new Cat(dadName,catGrandpa,null);

        String momName = reader.readLine();
        Cat catMom = new Cat(momName,null,catGrandma);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catDad, catMom);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catDad, catMom);

        System.out.println(catGrandpa);
        System.out.println(catGrandma);
        System.out.println(catDad);
        System.out.println(catMom);
        System.out.println(catSon);
        System.out.println(catDaughter);

    }

    public static class Cat {
        private String name;
        private Cat dad;
        private Cat mom;


        Cat(String name) {
            this.name = name;
        }

        //Cat(String name, Cat mom) { }

        Cat(String name, Cat dad, Cat mom){
            this.name = name;
            this.dad=dad;
            this.mom= mom;
            //this(name,mom);

        }

        @Override
        public String toString() {
            if ((mom == null)&&(dad == null))
                return "The cat's name is "+name+", no mother, no father"; //дедушка Вася
            else if((mom != null)&&(dad == null))
                return "The cat's name is "+name+", mother is "+mom.name+", no father";//мама Василиса&бабушка Мурка
            else if((mom == null)&&(dad != null))
                return "The cat's name is "+name+", no mother, father is "+dad.name;//папа Котофей&дедушка Вася";
            else
                return "The cat's name is "+name+", mother is "+mom.name+", father is "+dad.name;//сын Мурчик+мама Василиса+папа Котофей
            //"The cat's name is " + name + ", mother is " + mom.name;
        }
    }

}
