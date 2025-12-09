package org.example;// File: ReentrantLockCounterDemo.java
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounterDemo {
    static class Counter {
        private int count = 0;
        private final ReentrantLock lock = new ReentrantLock();

        public void increment() {
            lock.lock();
            try {
                int tmp = count;
                // simulate work
                try { Thread.sleep(1); } catch (InterruptedException e) {}
                count = tmp + 1;
            } finally {
                lock.unlock();
            }
        }

        public int get() {
            lock.lock();
            try {
                return count;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread[] threads = new Thread[4];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) counter.increment();
            }, "T-" + i);
            threads[i].start();
        }

        for (Thread t : threads) t.join();

        System.out.println("Expected: 4000, Actual: " + counter.get());
    }
}
