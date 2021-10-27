package com.javarush.task.task32.test;

public class RealObject implements MyInterface {
    @Override
    public void doSomething() {
        System.out.println("RealObject.doSomething");
    }

    @Override
    public void doSomethingElse(String arg) {
        System.out.println("RealObject.doSomethingElse(" + arg + ")");
    }
}
