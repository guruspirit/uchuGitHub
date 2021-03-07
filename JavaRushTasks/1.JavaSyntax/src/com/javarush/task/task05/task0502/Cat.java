package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        //напишите тут ваш код
        int x=0;
        if (this.age>anotherCat.age)
            x++;
        else if(this.age<anotherCat.age)
            x--;
        if (this.weight>anotherCat.weight)
            x++;
        else if(this.weight<anotherCat.weight)
            x--;
        if(this.strength>anotherCat.strength)
            x++;
        else if(this.strength<anotherCat.strength)
            x--;
        if(x>0)
            return true;
        else
            return false;

    }

    public static void main(String[] args) {

    }
}
