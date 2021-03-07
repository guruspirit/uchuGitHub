package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        //напишите тут ваш код
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < 10; i++) {
            map.put("M"+i,(i+1)*100);
        }
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        //напишите тут ваш код
        Map<String,Integer> tmap = new HashMap<String, Integer>();
        for(Map.Entry<String, Integer> x: map.entrySet()){
            if(x.getValue()<500)
                tmap.put(x.getKey(),x.getValue());
        }
        for(Map.Entry<String,Integer> x: tmap.entrySet()){
            map.remove(x.getKey());
        }
        
    }

    public static void main(String[] args) {

    }
}