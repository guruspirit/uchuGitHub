package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Human grandpa1 = new Human("Дед1",true,80);
        Human grandma1 = new Human("Баба1", false,75);
        Human grandpa2 = new Human("Дед2",true,70);
        Human grandma2 = new Human("Баба2", false,70);
        Human mom = new Human("мама", false,40,grandma1,grandpa1);
        Human dad = new Human("папа", true,42,grandma2,grandpa2);
        Human daughter = new Human("дочь", false,20,mom,dad);
        Human son = new Human("сын", true,17,mom,dad);
        Human son2 = new Human("сын2", true,10,mom,dad);
        System.out.println(grandma1.toString());
        System.out.println(grandma2.toString());
        System.out.println(grandpa1.toString());
        System.out.println(grandpa2.toString());
        System.out.println(mom.toString());
        System.out.println(dad.toString());
        System.out.println(daughter.toString());
        System.out.println(son.toString());
        System.out.println(son2.toString());
    }

    public static class Human {
        // напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human mother;
        Human father;
        public Human(String name, boolean sex, int age)
        {
            this.name=name;
            this.sex=sex;
            this.age=age;
        }

        public Human(String name, boolean sex, int age, Human mother, Human father){
            this(name,sex,age);
            this.mother=mother;
            this.father=father;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}