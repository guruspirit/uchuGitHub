package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне2", dateFormat.parse("Jun 1 2012"));
        map.put("Сталлоне3", dateFormat.parse("Jul 1 2012"));
        map.put("Сталлоне4", dateFormat.parse("Aug 1 2012"));
        map.put("Сталлоне5", dateFormat.parse("Sep 1 2012"));
        map.put("Сталлоне6", dateFormat.parse("Oct 1 2012"));
        map.put("Сталлоне7", dateFormat.parse("Nov 1 2012"));
        map.put("Сталлоне8", dateFormat.parse("Dec 1 2012"));
        map.put("Сталлоне9", dateFormat.parse("Jan 1 2012"));
        map.put("Сталлоне10", dateFormat.parse("Feb 1 2012"));

        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        //напишите тут ваш код
        Map<String, Date> tMap = new HashMap<>();

        DateFormat dateFormat = new SimpleDateFormat("MMM", Locale.ENGLISH);
        for(Map.Entry<String,Date> pair: map.entrySet()){
            String name = pair.getKey();
            Date date = pair.getValue();
            //System.out.println(dateFormat.format(date));
            if(dateFormat.format(date).equals("Jun")||dateFormat.format(date).equals("Jul")||dateFormat.format(date).equals("Aug")) {
                tMap.put(name, date);
            //    System.out.println(" + ");
            }

        }
        for(Map.Entry<String,Date> pair: tMap.entrySet())
            map.remove(pair.getKey());
    }

    public static void main(String[] args) throws ParseException {
        /*
        Map<String, Date> map = createMap();
        removeAllSummerPeople(map);
        for(Map.Entry<String, Date> pair: map.entrySet())
            System.out.println(pair.getKey()+" "+pair.getValue());*/
        //SimpvleDateFormat sdf = new SimpleDateFormat("MMM", Locale.ENGLISH);
        //System.out.println(sdf.format(new Date()));

    }
}
