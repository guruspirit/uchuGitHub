package com.javarush.task.task05.task0512;

/* 
Создать класс Circle
*/

import java.util.Objects;

public class Circle {
    //напишите тут ваш код
    int centerX,centerY,radius,width,color;
    public void initialize(int centerX, int centerY,int radius){
        this.centerX=centerX;
        this.centerY=centerY;
        this.radius=radius;
    }
    public void initialize(int centerX, int centerY,int radius, int width){
        this.centerX=centerX;
        this.centerY=centerY;
        this.radius=radius;
        this.width=width;
    }
    public void initialize(int centerX, int centerY,int radius, int width,int color){
        this.centerX=centerX;
        this.centerY=centerY;
        this.radius=radius;
        this.width=width;
        this.color=color;
    }
    public static void main(String[] args) {

    }
}
