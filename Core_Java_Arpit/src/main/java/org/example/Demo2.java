package org.example;

class MyTask implements Runnable {
    @Override
    public void run() {
        // Code that will run in this new thread
        for (int i = 1; i <= 5; i++) {
            System.out.println("MyTask: " + i);
        }
    }
}

public class Demo2 {
    public static void main(String[] args) {
        Runnable task = new MyTask();
        Thread t = new Thread(task);  // pass task to Thread
        t.start();                    // starts a new thread

        // main thread
        for (int i = 1; i <= 5; i++) {
            System.out.println("Main: " + i);
        }
    }
}
