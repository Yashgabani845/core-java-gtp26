package org.example;

class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    // Synchronized to prevent race conditions
    public boolean withdraw(int amount) {
        if (balance >= amount) {
            // simulate processing delay
//            try { Thread.sleep(10); } catch (InterruptedException e) {}

            balance -= amount;
            System.out.println(Thread.currentThread().getName() +
                    " withdrew " + amount + ", Remaining = " + balance);
            return true;
        } else {
            System.out.println(Thread.currentThread().getName() +
                    " FAILED withdrawal of " + amount + ", Remaining = " + balance);
            return false;
        }
    }

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() +
                " deposited " + amount + ", New Balance = " + balance);
    }

    public int getBalance() {
        return balance;
    }
}

public class BankingSimulation {
    public static void main(String[] args) throws Exception {

        BankAccount account = new BankAccount(150);  // initial balance = 150

        // Task: Withdraw 100 rupees
        Runnable withdrawTask = () -> {
            account.withdraw(100);
        };

        // Running withdraw 2 times simultaneously with multiple threads
        Thread t1 = new Thread(withdrawTask, "T1");
        Thread t2 = new Thread(withdrawTask, "T2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Balance = " + account.getBalance());
    }
}
