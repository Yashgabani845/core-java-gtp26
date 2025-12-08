package org.example;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {

    public static void main(String[] args) {

        // LinkedList → backed by linked nodes
        List<String> tasks = new LinkedList<>();

        tasks.add("Wake up");
        tasks.add("Brush");
        tasks.add("Exercise");

        System.out.println("LinkedList: " + tasks);

        // Fast insertion at beginning → O(1)
        tasks.add(0, "Drink Water");
        System.out.println("After adding at beginning: " + tasks);

        // Fast removal from beginning → O(1)
        tasks.remove(0);
        System.out.println("After removing first: " + tasks);

        // Slow random access → O(n)
        System.out.println("Task at index 1: " + tasks.get(1));
    }
}
