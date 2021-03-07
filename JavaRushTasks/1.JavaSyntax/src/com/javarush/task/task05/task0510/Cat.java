package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    //напишите тут ваш код
    String name;
    int age;
    int weight;
    String color;
    String address;
    public void initialize(String name){
        this.name=name;
        weight=1000;
        age=2;
        color="Gray";
        address=null;
    }
    public void initialize(String name, int weight, int age){
        this.name=name;
        this.weight=weight;
        this.age=age;
        color="Gray";
        address=null;
    }
    public void initialize(String name, int age){
        this.name=name;
        weight=1000;
        this.age=age;
        color="Gray";
        address=null;
    }
    public void initialize(int weight,String color){
        this.name=null;
        this.weight=weight;
        age=2;
        this.color=color;
        address=null;
    }
    public void initialize(int weight,String color, String address){
        this.name=null;
        this.weight=weight;
        age=2;
        this.color=color;
        this.address=address;
    }
    public static void main(String[] args) {

    }
}
