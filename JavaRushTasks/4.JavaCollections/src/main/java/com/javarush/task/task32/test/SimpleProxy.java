package com.javarush.task.task32.test;

public class SimpleProxy implements MyInterface {
    private MyInterface proxied;
    public SimpleProxy(MyInterface proxied) {
        this.proxied = proxied;
    }
    @Override
    public void doSomething() {
        System.out.println("SimpleProxy.doSomething()");
        proxied.doSomething();
    }

    @Override
    public void doSomethingElse(String arg) {
        System.out.println("SimpleProxy.doSomethingElse(" + arg + ")");
        proxied.doSomethingElse(arg);
    }
}
