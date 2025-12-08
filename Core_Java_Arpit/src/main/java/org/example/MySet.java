package org.example;

import java.util.HashSet;
import java.util.Set;

public class MySet {

    public static void main(String[] args){
        Set<String>s=new HashSet<>();
        System.out.println("Set Elements: " + s);
        s.add("B");
        s.add("B");
        s.add("C");
        s.add("A");
        s.add("F");
        s.add("D");
        System.out.println("Set Elements: " + s);

        String str = "E";
        System.out.println("Do "+s+" Contains " + str + " "+ s.contains(str));
        s.remove("B");
        System.out.println("After removing element " + s);
        for (String value : s)
            // Printing all the values inside the object
            System.out.print(value + ", ");
        System.out.println();
    }

}