package org.example;

public class ThreadSync {
    private int count=0;

    public synchronized void increment(){
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSync thr=new ThreadSync();
        try {
            thr.doWork();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void doWork() throws InterruptedException {
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                    increment();
                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                    increment();
                    // count++ here works fine but if we do count=count+1 then we may get different answer then expected
                }
            }
        });
        t1.start();
        t2.start();
//Without jining the count will be 0 because first the print statement gets executed
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(count);
    }

}