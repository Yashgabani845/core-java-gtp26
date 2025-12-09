package org.example;

import java.util.*;

public class Lambda {

    public static void main(String[] args){
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
//        Without lambda
//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String a, String b) {
//                return b.compareTo(a);
//            }
//        });
//        System.out.println(names);

//        With Lambda
        Collections.sort(names, (a, b) -> a.compareTo(b));
        System.out.println(names);
    }

}