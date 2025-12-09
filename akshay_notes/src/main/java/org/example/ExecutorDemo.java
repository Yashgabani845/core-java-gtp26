package org.example;

import java.util.concurrent.*;

public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executorForA= Executors.newFixedThreadPool(5);
        ExecutorService executorForB= Executors.newFixedThreadPool(5);

        Callable<Integer> taskB = () -> {
            Thread.sleep(500);  // simulate work
            System.out.println("Task " + Thread.currentThread().getName() + " executed by " + Thread.currentThread().getName());
            return 20;
        };

        Callable<Integer> taskA= ()->{
            Future<Integer> ResultfromB= executorForB.submit(taskB);
            Integer ResultB= ResultfromB.get();
            System.out.println("Task " + Thread.currentThread().getName() + " executed by " + Thread.currentThread().getName());
            return ResultB+10;
        };

        for(int i=0;i<500;i++){
            Future<Integer> ResultfromA= executorForA.submit(taskA);
            try {
                Integer ResultA=ResultfromA.get();
                System.out.println("Result A is "+ResultA);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }



    }
}
