package com.javarush.task.task32.test;

import java.lang.reflect.Proxy;

public class SimpleDynamicProxy {
    public static void customer(MyInterface iface) {
        iface.doSomething();
        iface.doSomethingElse("later");
    }

    public static void main(String[] args) {
        RealObject real =  new RealObject();
        customer(real);
        MyInterface proxy = (MyInterface) Proxy.newProxyInstance(
                MyInterface.class.getClassLoader(),
                new Class[] {MyInterface.class},
                new DynamicProxyHandler(real)
        );
        customer(proxy);
    }
}
