package com.javarush.task.task32.task3206;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/* 
Дженерики для создания прокси-объекта
*/

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        test(solution.getProxy(Item.class));                        //true false false
        test(solution.getProxy(Item.class, Small.class));           //true false true
        test(solution.getProxy(Item.class, Big.class, Small.class));//true true true
        test(solution.getProxy(Big.class, Small.class));            //true true true т.к. Big наследуется от Item
        test(solution.getProxy(Big.class));                         //true true false т.к. Big наследуется от Item
    }

    public <T> Item getProxy(Class<T> item, Class ... interfaces) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        InvocationHandler invocationHandler = new ItemInvocationHandler();
        Class<T>[] interfaces1 = new Class[interfaces.length+1];
        interfaces1[0] = item;
        for(int i=1; i<interfaces.length+1; i++ ){
            interfaces1[i] =interfaces[i-1];
        }
        Item proxy = (Item) Proxy.newProxyInstance(classLoader,interfaces1,invocationHandler);
        return proxy;
    }

    private static void test(Object proxy) {
        boolean isItem = proxy instanceof Item;
        boolean isBig = proxy instanceof Big;
        boolean isSmall = proxy instanceof Small;

        System.out.format("%b %b %b\n", isItem, isBig, isSmall);
    }
}
