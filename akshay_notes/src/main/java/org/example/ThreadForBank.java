package org.example;

// Main class
public class ThreadForBank {
    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<1;i++){
            BankAccount.balance=1000;
            Thread A1 = new BankAccount("A1", 70);
            Thread A2 = new BankAccount("A2", 50);

            A1.start();
            A2.start();

            A1.join();
            A2.join();
        }

    }
}

// BankAccount thread class
class BankAccount extends Thread {

    // Shared balance between all threads
    static int balance = 1000;

    private final int amount;     // Amount to withdraw
    private final String user;    // Thread name

    // Constructor to set thread name & withdrawal amount
    BankAccount(String user, int amount) {
        this.user = user;
        this.amount = amount;
    }

    @Override
    public void run() {
        withdraw(amount,user);
    }

    // Synchronized method to avoid race condition
    private static void withdraw(int amount,String user) {
        String threadName = Thread.currentThread().getName();

//        System.out.println(threadName + " trying to withdraw " + amount);

        if (balance >= amount) {
//            System.out.println(threadName + " withdrawal successful!");
            balance -= amount;
        } else {
            System.out.println(threadName + " insufficient balance!");
        }
//        System.out.println(balance);
        if(balance<1000 && balance!=880) {
            System.out.println("Remaining balance = " + balance);
        }
    }
}
