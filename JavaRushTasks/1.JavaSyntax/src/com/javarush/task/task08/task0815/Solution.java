package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<String, String>();
        map.put("Сергей", "Фролов");
        map.put("Иван1", "Фролов");
        map.put("Артем1", "Дрон1");
        map.put("Артем", "Шеметов");
        map.put("Ира1", "Ирков");
        map.put("Андрей", "Шеметов");
        map.put("Костя", "Шеметов");
        map.put("Андрейка", "Дрон21");
        map.put("Иван", "Андрей");
        map.put("Ира", "Дрон");
        return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        //напишите тут ваш код
        int key=0;
        //Map<String, String> tmap = new HashMap<String, String>();
        for(Map.Entry<String, String> pair: map.entrySet()){
            //String xKey = pair.getKey();
            String xVal = pair.getValue();
            if (xVal==name)
                key++;
            //else{
            //  tmap.put(xKey,xVal);
            //          System.out.println(xKey+" "+xVal);
            //}
        }
        return key;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        //напишите тут ваш код
        int key=0;
        //Map<String, String> tmap = new HashMap<String, String>();
        for(Map.Entry<String, String> pair: map.entrySet()){
            String xKey = pair.getKey();
            //String xVal = pair.getValue();
            if (xKey==lastName)
                key++;
            //else{
            //  tmap.put(xKey,xVal);
            //          System.out.println(xKey+" "+xVal);
            //}
        }
        return key;

    }

    public static void main(String[] args) {
        /*Map<String, String> tmap = createMap();
        int fn = getCountTheSameFirstName(tmap,"Ира");
        int sn = getCountTheSameLastName(tmap, "Дрон");
        System.out.println(fn+" "+sn);*/
    }
}
