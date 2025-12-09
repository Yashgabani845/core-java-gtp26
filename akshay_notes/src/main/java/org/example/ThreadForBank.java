package org.example;

import java.util.*;

// Main class
public class ThreadForBank {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 250; i++) {
            Thread A1 = new BankAccount("A1", 1);
            Thread A3 = new BankAccount("A1", 1);
            Thread A2 = new BankAccount("A2", 2);
            threads.add(A1); threads.add(A2); threads.add(A3);
            A1.start(); A2.start(); A3.start();
        }
        for (Thread t : threads) t.join();
        System.out.println("Bank balance after transactions " + BankAccount.balance);

    }
}

// BankAccount thread class
class BankAccount extends Thread {
    static int balance = 1000;
    private final int amount;
    private final String user;

    private static final Object LOCK = new Object(); // stable lock

    BankAccount(String user, int amount) {
        this.user = user;
        this.amount = amount;
    }

    @Override
    public void run() {
        withdraw(amount, user);
    }

    private static synchronized void withdraw(int amount, String user) {
        String threadName = Thread.currentThread().getName();
//        synchronized (LOCK) {
            if (balance >= amount) {
                balance -= amount;
                // optionally log
            } else {
                System.out.println(threadName + " insufficient balance!");
            }
//        }
    }
}
