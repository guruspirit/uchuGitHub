package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();
        map.put("Иванов","Иван");
        map.put("a","aname");
        map.put("b","bname");
        map.put("c","aname");
        map.put("d","dname");
        map.put("e","ename");
        map.put("f","aname");
        map.put("g","gname");
        map.put("h","hname");
        map.put("i","iname");
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) throws Exception{
        //напишите тут ваш код
        Map<String, String> tmap = new HashMap<String, String>();
        Map<String, String> copy = new HashMap<>(map);
        for(Map.Entry<String, String> pair : copy.entrySet()){
            String pVal = pair.getValue();
            String pKey = pair.getKey();

            if(tmap.containsValue(pVal))
                removeItemFromMapByValue(map,pVal);
            else
                tmap.put(pKey,pVal);
        }

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        /*Map<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
        //removeItemFromMapByValue(map,"aname");
        for(Map.Entry<String, String> pair: map.entrySet())
            System.out.println(pair.getKey()+" "+pair.getValue());
*/
    }
}
