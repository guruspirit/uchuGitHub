package com.javarush.task.task08.task0820;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Set;

/* 
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        System.out.println("Current pets:");
        printPets(pets);
        System.out.println("Remove Cats: ...");
        removeCats(pets, cats);
        System.out.println("Pets after remove cats");
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        Set<Cat> result = new HashSet<Cat>();
        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());
        return result;
    }

    public static Set<Dog> createDogs() {
        Set<Dog> result = new HashSet<Dog>();
        result.add(new Dog());
        result.add(new Dog());
        result.add(new Dog());
        return result;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        Set<Object> pets = new HashSet<Object>();
        for(Cat tempCat: cats){
            pets.add(tempCat);
        }
        for(Dog tempDog: dogs){
            pets.add(tempDog);
        }
        return pets;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        //напишите тут ваш код
        for(Cat cat: cats){
            pets.remove(cat);
        }
    }

    public static void printPets(Set<Object> pets) {
        for(Object pet: pets){
            System.out.println(pet);
        }
    }
    public static class Cat{
        public Cat(){}
    }
    public static class Dog{
        public Dog(){}
    }
    //напишите тут ваш код
}
