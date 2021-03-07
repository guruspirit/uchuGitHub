package com.javarush.task.task08.task0829;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Модернизация ПО
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //List<String> list = new ArrayList<>();
        Map<String,String> note = new HashMap<String,String>();

        while (true) {
            String country = reader.readLine();
            if (country.isEmpty())
                break;
            String family = reader.readLine();
            if (family.isEmpty())
                break;
            note.put(country,family);
            //list.add(family);
        }

        // Read the house number
        //int houseNumber = Integer.parseInt(reader.readLine());
        //System.out.println("Введите город: ");
        String findCity= reader.readLine();
        System.out.println(note.get(findCity));
        //if (0 <= houseNumber && houseNumber < list.size()) {
        //    String familyName = list.get(houseNumber);
        //    System.out.println(familyName);
        //}
    }
}
