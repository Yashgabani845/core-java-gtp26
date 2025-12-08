package org.example;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Iterator;

public class MyDequeque {

    public static void main(String[] args){
        // Create a Deque of Strings
        Deque<String> d = new ArrayDeque<>();
        d.addFirst("1");
        d.addLast("2");
//        String f = d.removeFirst();
//        String l = d.removeLast();
        // Displaying the Deque
//        System.out.println("First: " + f + ", Last: " + l);
        System.out.println(d.pop());
        System.out.println(d.poll());
        System.out.println(d.pollFirst());
        System.out.println(d.pollLast());

        // Initializing an deque
        Deque<String> dq = new ArrayDeque<String>();

        // add() method to insert
        dq.add("For");
        dq.addFirst("Geeks");
        dq.addLast("Geeks");
        dq.add("is so good");
        for (Iterator itr = dq.iterator(); itr.hasNext();) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
        // descendingIterator:- To traverse the deque in reverse order
        for (Iterator itr = dq.descendingIterator();  itr.hasNext();) {
            System.out.print(itr.next() + " ");
        }
    }

}