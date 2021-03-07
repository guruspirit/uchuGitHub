package com.javarush.task.task10.task1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> map = new HashMap<String, String>();
        String key,value;
        try {
            while (true) {
                value = reader.readLine();
                if (value.equals(""))
                    break;
                else {
                    key = reader.readLine();
                    if (key.equals("")) {
                        map.put("", value);
                        break;
                    }
                    else {
                        map.put(key, value);
                    }
                }
            }
        } catch (Exception e){}
        for(Map.Entry<String,String> pair: map.entrySet())
            System.out.println(pair.getValue() + " " + pair.getKey());
    }
}
