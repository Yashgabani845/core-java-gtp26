package org.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


import java.util.ArrayList;

public class MyCollection {

    public static void main(String[] args){

        Collection<String> cricketers=new ArrayList<String>();
        cricketers.add("Virat Kohli");
        cricketers.add("Rohit Sharma");
        System.out.println(cricketers);

        Collection<Integer> numbers = new ArrayList<>();

        // Adding individual elements
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        System.out.println("Before adding elements: " + numbers);

        // Adding another collection
        Collection<Integer> moreNumbers = new ArrayList<>();
        moreNumbers.add(40);
        moreNumbers.add(50);

        numbers.addAll(moreNumbers);

        System.out.println("After adding elements: " + numbers);

        numbers.removeAll(Arrays.asList(10,20));
        //numbers.removeAll(moreNumbers)

        System.out.println("After removing elements: " + numbers);

    }

}