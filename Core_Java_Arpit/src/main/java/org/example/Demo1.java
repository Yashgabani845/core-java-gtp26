package org.example;

class MyThread extends Thread {
    @Override
    public void run() {
        // Code that will run in this new thread
        for (int i = 1; i <= 5; i++) {
            System.out.println("MyThread: " + i);
        }
    }
}

public class Demo1 {
    public static void main(String[] args) {
        MyThread t = new MyThread(); // create thread object
        t.start();                   // start new thread (NEVER call run() directly)

        // main thread code
        for (int i = 1; i <= 5; i++) {
            System.out.println("Main: " + i);
        }
    }
}
