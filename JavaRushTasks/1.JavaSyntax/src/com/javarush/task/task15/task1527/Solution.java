package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Парсер реквестов

http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo

Вывод:
obj name
double: 3.14
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        str = reader.readLine();
        reader.close();
        List<String> list = new ArrayList<String>();
        //str = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";
        int startIndex = str.indexOf("?")+1; // ищем"?", он 35й начинаем с 36 элемента
        for (int i = startIndex; i < str.length(); i++) {
                int endIndex = str.indexOf("&", i); // = 42
                if (endIndex>0)
                    list.add(str.substring(startIndex, endIndex));
                else {
                    list.add(str.substring(startIndex,str.length()));
                    break;
                }
                startIndex = endIndex + 1;
                i=startIndex;
        }
        // обработка листа
        List<String> list2 = new ArrayList<>();
        String param;
        double x=0d;
        boolean isX=false;
        String s="";
        String key="";
        //  формирование списка с параметрами
        for (int i = 0; i < list.size(); i++) {
            str = list.get(i); //текущий элемент str obj=3.14
            if (str.contains("=")) {
                int endIndex = str.indexOf("=");
                param = str.substring(0, endIndex);
                list2.add(param);
            } else
                list2.add(str);
        }
        //  вывод списка с параметрами
        for (int i = 0; i < list2.size(); i++) {
            System.out.print(list2.get(i) + " ");
        }
        System.out.println("");

        int x1;
        // for (int i = 0; i < list.size(); i++) {
        //http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
            if((x1=list2.indexOf("obj"))!=-1) { //x1 = номер элемента в списке
                key = list.get(x1).substring(4);
                try {
                    x = Double.parseDouble(key);
                    alert(x);
                } catch (Exception e) {
                    alert(key);
                }
            }

    }
    public static void alert(double value){
        System.out.println("double: " + value);
    }
    public static void alert(String value){
        System.out.println("String: " + value);
    }
}
