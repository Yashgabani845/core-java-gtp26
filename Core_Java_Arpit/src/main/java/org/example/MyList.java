package org.example;

import java.util.ArrayList;
import java.util.List;

public class MyList {

    public static void main(String[] args){
        List<String> languages= new ArrayList<String>();
        //  add(Object o) and add(int index,Object o)
        languages.add("C");
        languages.add("C++");
        languages.add("Java");
        languages.add("Python");
        System.out.println("The languages i know are");
        for(String s:languages){
            System.out.print(s+", ");
        }
        System.out.println();
        int n=languages.size();
        System.out.println("The number of languages i know are "+ n);

        // updating set(int index, Object newValue)

        // indexOf method for finding index of an item in list

        int in=languages.indexOf("C++");
        System.out.println("The index of C++ is "+in);
        int in1=languages.indexOf("Go");
        System.out.println("The index of Go is "+in1);
        // -1 index means not found inside the list
        languages.remove("Python");
        System.out.println(languages);
        languages.remove("Go");
        System.out.println(languages);
        System.out.println("First language i learnt is "+languages.get(0));// Printing 1st language
        System.out.println("Last language i learnt is "+languages.get(languages.size()-1));// Printing last language
        System.out.println("Checking whether i learnt C++? "+languages.contains("C++"));
    }

}