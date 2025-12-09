package org.example;

import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) throws Exception {

        // Create a thread pool with 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Submit a Callable task (this is the event)
        Callable<String> task = () -> {
            System.out.println("Executing task in: " + Thread.currentThread().getName());
            Thread.sleep(1000);  // simulate slow computation
            return "Task Completed Successfully!";
        };

        // Submit task and get a Future
        Future<String> future = executor.submit(task);

        System.out.println("Task submitted. Doing other work...");

        // Check if task is done (optional)
        while (!future.isDone()) {
            System.out.println("Task still processing...");
            Thread.sleep(300);
        }

        // Get the result from Future
        String result = future.get();   // This waits until the result is available

        System.out.println("Result received from Future: " + result);
        executor.shutdown();
    }
}