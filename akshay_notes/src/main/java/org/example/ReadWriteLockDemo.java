// File: ReadWriteLockDemo.java
package org.example;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.ThreadLocalRandom;

public class ReadWriteLockDemo {
    static class SharedData {
        private int value = 0;
        private final ReentrantReadWriteLock rw = new ReentrantReadWriteLock();

        // writer
        public void write(int v) {
            rw.writeLock().lock();
            try {
                // simulate write work
                try { Thread.sleep(2); } catch (InterruptedException e) {}
                value = v;
            } finally {
                rw.writeLock().unlock();
            }
        }

        // reader
        public int read() {
            rw.readLock().lock();
            try {
                // simulate read work
                try { Thread.sleep(1); } catch (InterruptedException e) {}
                return value;
            } finally {
                rw.readLock().unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SharedData data = new SharedData();

        // create many reader threads
        Thread[] readers = new Thread[20];
        for (int i = 0; i < readers.length; i++) {
            readers[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    int v = data.read();
                    // optionally print occasionally
                    if (ThreadLocalRandom.current().nextInt(1000) == 0)
                        System.out.println(Thread.currentThread().getName() + " read " + v);
                }
            }, "R-" + i);
            readers[i].start();
        }

        // create some writer threads
        Thread[] writers = new Thread[3];
        for (int i = 0; i < writers.length; i++) {
            writers[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    int newVal = ThreadLocalRandom.current().nextInt(10000);
                    data.write(newVal);
                    // optionally print occasionally
                    if (ThreadLocalRandom.current().nextInt(500) == 0)
                        System.out.println(Thread.currentThread().getName() + " wrote " + newVal);
                    try { Thread.sleep(5); } catch (InterruptedException e) {}
                }
            }, "W-" + i);
            writers[i].start();
        }

        for (Thread t : readers) t.join();
        for (Thread t : writers) t.join();

        System.out.println("Final value: " + data.read());
    }
}
