package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human daughter1 = new Human("Джесика",false,10,new ArrayList<Human>());;
        Human son1 = new Human("Леонид",true,15,new ArrayList<Human>());
        Human son2 = new Human("Алекс",true,18,new ArrayList<Human>());
        Human father1 = new Human("ПапаИгорь",true,40,new ArrayList<Human>(Arrays.asList(son1,son2,daughter1)));
        Human mother1 = new Human("МамаОля",false,39,new ArrayList<Human>(Arrays.asList(son1, son2, daughter1)));
        Human grandma2 = new Human("БабаЮля",false,78,new ArrayList<Human>(Arrays.asList(father1)));
        Human grandma1 = new Human("БабаЯна",false,79,new ArrayList<Human>(Arrays.asList(mother1)));
        Human grandpa2 = new Human("ДедИван",true,81,new ArrayList<Human>(Arrays.asList(father1)));
        Human grandpa1 = new Human("ДедАндрей",true,80,new ArrayList<Human>(Arrays.asList(mother1)));
        System.out.println(daughter1);
        System.out.println(son1);
        System.out.println(son2);
        System.out.println(father1);
        System.out.println(mother1);
        System.out.println(grandma1);
        System.out.println(grandma2);
        System.out.println(grandpa1);
        System.out.println(grandpa2);
    }

    public static class Human {

        //напишите тут ваш код
        String name;
        Boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, Boolean sex, int age){
            this.name=name;
            this.sex=sex;
            this.age=age;
        }
        public Human(String name, Boolean sex, int age, ArrayList <Human> children){
            this.name=name;
            this.age=age;
            this.sex=sex;
            this.children= children;
        }


        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
