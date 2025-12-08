package org.example;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Iterator;
public  class MyQueue {

    public static void main(String[] args){
        Queue<String>q=new PriorityQueue<>();
        q.add("Arpit");
        q.add("Yash");
        q.add("Akshay");
        q.add("Apeksha");
        System.out.println("Priority queue contains"+ q);
        q.remove("Akshay");
        System.out.println("After Remove: " + q);
        System.out.println("Poll Method: " + q.poll());
        //Use poll() when: You want safe removal
        //You don’t want exceptions when queue is empty
        System.out.println("Final Queue: " + q);
        System.out.println("Iterating using iterator");
        Iterator iterator = q.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }

}