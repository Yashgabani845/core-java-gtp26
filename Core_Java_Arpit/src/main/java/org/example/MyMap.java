package org.example;

import java.util.Map;
import java.util.TreeMap;

public class MyMap {

    public static void main(String[] args) {
        Map<Integer, String> m = new TreeMap<>();
        // Adding key-value pairs to the map
        m.put(2,"Geek1");
        m.put(3,"Geek2");
        m.put(1,"Geek3");
        System.out.println("Map elements: " + m);
        m.put(2,"2nd Geek");
        System.out.println("Map elements: " + m);
        for (Map.Entry mapElement : m.entrySet()) {
            int key = (int)mapElement.getKey();
            // Finding the value
            String value = (String)mapElement.getValue();
            System.out.println(key + " : " + value);
        }
        m.remove(3);
        System.out.println("Map elements: " + m);
    }

}