package com.javarush.task.task32.test;

public class MainClass {
    public static void customer(MyInterface iFace) {
        iFace.doSomething();
        iFace.doSomethingElse("");
    }

    public static void main(String[] args) {
        customer(new RealObject());
        customer(new SimpleProxy(new RealObject()));
        //new RealObject().doSomething();
        //new SimpleProxy(new RealObject());
    }
}
