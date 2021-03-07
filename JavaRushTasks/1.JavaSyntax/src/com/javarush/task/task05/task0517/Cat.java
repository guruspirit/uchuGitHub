package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    //напишите тут ваш код
    String name, color, address;
    int weight, age;
    public Cat(String name){this.name=name;this.color="gray";this.address=null;this.weight=1000;this.age=1;}
    public Cat(String name, int weight, int age){this.name=name;this.color="gray";this.address=null;this.weight=weight;this.age=age;}
    public Cat(String name, int age){this.name=name;this.color="gray";this.address=null;this.weight=1000;this.age=age;}
    public Cat(int weight, String color){this.name=null;this.color=color;this.address=null;this.weight=weight;this.age=1;}
    public Cat(int weight, String color, String address){this.name=null;this.color=color;this.address=address;this.weight=weight;this.age=1;}
    public static void main(String[] args) {

    }
}
