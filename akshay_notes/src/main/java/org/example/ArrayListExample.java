package org.example;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

    public static void main(String[] args) {

        // ArrayList → backed by a dynamic array
        List<String> students = new ArrayList<>();

        students.add("Akshay");
        students.add("Rahul");
        students.add("Neha");

        System.out.println("ArrayList: " + students);

        // Fast random access → O(1)
        System.out.println("Student at index 1: " + students.get(1));

        // Removing from the middle is costly → O(n)
        students.remove(1);
        System.out.println("After removing Rahul: " + students);
    }
}
