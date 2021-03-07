package com.javarush.task.task10.task1013;

public class Solution {
    public static void main(String[] args) {

    }
    public static class Human{
        private int a;
        private int b;
        private String c;
        private  String d;
        private double e;
        private long f;

        public Human(int a){
            this.a=a;
        }
        public Human(int a, int b){
            this(a);
            this.b=b;
        }

        public Human(int a, String c){
            this(a);
            this.c=c;
        }
        public Human(int a, String c, String d){
            this(a,c);
            this.d=d;
        }
        public Human(int a, String c, String d, double e){
            this(a,c,d);
            this.e=e;
        }
        public Human(int a, String c, String d, double e, long f){
            this(a,c,d,e);
            this.f=f;
        }
        public Human(int a, int b, String c){
            this(a,b);
            this.c=c;
        }
        public Human(int a, int b, String c, String d){
            this(a,b,c);
            this.d=d;
        }
        public Human(int a, int b, String c, String d,double e){
            this(a,b,c,d);
            this.e=e;
        }
        public Human(int a, int b, String c, String d,double e, long f){
            this(a,b,c,d,e);
            this.f=f;
        }
    }
}
