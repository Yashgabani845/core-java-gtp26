package org.example;

public class SimpleVolatileDemo {

    private static volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {

        // Thread 1 increments count 5000 times
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                count++; // NOT ATOMIC
            }
        });

        // Thread 2 increments count 5000 times
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                count++; // NOT ATOMIC
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Expected = 10000");
        System.out.println("Actual   = " + count);
    }
}
