package org.example;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class SemaphoreExample {

    // Helper method for sleeping
    private static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Graceful shutdown helper
    private static void stop(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(10);

        // Only 5 threads allowed at a time
        Semaphore semaphore = new Semaphore(5);

        Runnable longRunningTask = () -> {
            boolean permit = false;
            try {
                // Try to acquire permit within 1 second
                permit = semaphore.tryAcquire(1, TimeUnit.SECONDS);

                if (permit) {
                    System.out.println(Thread.currentThread().getName() +
                            " → Semaphore acquired");
                    sleep(5);
                } else {
                    System.out.println(Thread.currentThread().getName() +
                            " → Could not acquire semaphore");
                }

            } catch (InterruptedException e) {
                throw new IllegalStateException(e);

            } finally {
                if (permit) {
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() +
                            " → Semaphore released");
                }
            }
        };

        // Submit 10 tasks
        IntStream.range(0, 10)
                .forEach(i -> executor.submit(longRunningTask));

        stop(executor);
    }
}
