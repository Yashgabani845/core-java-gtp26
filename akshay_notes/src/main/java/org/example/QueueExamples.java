package org.example;

import java.util.*;

/**
 * Demonstrates the three main Queue implementations:
 * 1. ArrayDeque  - fastest, recommended for normal FIFO queue
 * 2. LinkedList  - queue backed by linked nodes, allows nulls
 * 3. PriorityQueue - NOT FIFO; returns smallest/highest priority element first
 *
 * ALSO demonstrates all commonly used queue methods:
 * offer, add, poll, remove, peek, element, size, isEmpty, contains
 */
public class QueueExamples {

    public static void main(String[] args) {

        arrayDequeQueueDemo();
        linkedListQueueDemo();
        priorityQueueDemo();
    }

    // ---------------------------------------------------------
    // 1) ArrayDeque as Queue (BEST choice for normal FIFO queue)
    // ---------------------------------------------------------
    static void arrayDequeQueueDemo() {
        System.out.println("\n=== ArrayDeque Queue Example ===");

        // ArrayDeque is the recommended Queue implementation.
        Queue<String> queue = new ArrayDeque<>();

        // ADDING ELEMENTS
        queue.offer("A"); // preferred: no exception if full (null means fail)
        queue.offer("B");
        queue.offer("C");

        System.out.println("Initial queue: " + queue); // FIFO order

        // ACCESSING HEAD ELEMENT
        System.out.println("peek(): " + queue.peek()); // A (head)

        // REMOVING ELEMENTS
        System.out.println("poll(): " + queue.poll()); // removes A
        System.out.println("After poll: " + queue);

        // SIZE + CHECKS
        System.out.println("Contains B? " + queue.contains("B"));
        System.out.println("size(): " + queue.size());
        System.out.println("isEmpty(): " + queue.isEmpty());
    }

    // ---------------------------------------------------------
    // 2) LinkedList as Queue
    // ---------------------------------------------------------
    static void linkedListQueueDemo() {
        System.out.println("\n=== LinkedList Queue Example ===");

        // LinkedList also implements Queue interface
        Queue<Integer> queue = new LinkedList<>();

        // ADDING ELEMENTS
        queue.add(10);   // add() throws exception on failure
        queue.add(20);
        queue.add(30);

        System.out.println("Initial queue: " + queue);

        // ACCESSING
        System.out.println("peek(): " + queue.peek()); // 10

        // REMOVING
        System.out.println("remove(): " + queue.remove()); // removes 10
        System.out.println("After remove: " + queue);

        // LinkedList SPECIAL: allows null values
        queue.add(null);
        System.out.println("After adding null: " + queue);
    }

    // ---------------------------------------------------------
    // 3) PriorityQueue (NOT FIFO)
    //    Always returns the SMALLEST (or highest priority) element first
    // ---------------------------------------------------------
    static void priorityQueueDemo() {
        System.out.println("\n=== PriorityQueue Example ===");

        // Min-heap priority queue by default (smallest number has highest priority)
        Queue<Integer> pq = new PriorityQueue<>();

        pq.offer(50);
        pq.offer(10);
        pq.offer(40);
        pq.offer(20);

        System.out.println("Internal structure (heap): " + pq);

        // POLLING returns elements in SORTED PRIORITY order
        System.out.println("Polling in priority order:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());  // 10, 20, 40, 50
        }
    }
}
