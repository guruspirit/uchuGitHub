package com.javarush.task.task09.task0918;

/* 
Все свои, даже исключения
*/

public class Solution {
    public static void main(String[] args) {
    }

    static class MyException extends Exception{
        public MyException(String message){
            super(message);
        }
    }

    static class MyException2 extends Exception{
    public MyException2(String message){
        super(message);
    }
    }

    static class MyException3 extends Error{
        public  MyException3(String message){
            super(message);
        }
    }

    static class MyException4 extends Error{
        public MyException4(String message){
            super(message);
        }
    }
}

