package multithreading;

public class bank {
    private int balance = 1000;

    synchronized void deposit(int amount){
        balance = balance + amount;
        System.out.println(Thread.currentThread().getName() + " Deposited: " + amount + " | Balance: " + balance);
    }

    synchronized void withdraw(int amount) {
        if (balance - amount >= 0) {
            balance = balance - amount;
            System.out.println(Thread.currentThread().getName() + " Withdrawn: " + amount + " | Balance: " + balance);

        } else {
            System.out.println(Thread.currentThread().getName() + " Tried to withdraw " + amount + " but insufficient balance!");
        }
    }

    public static void main(String[] args) {

        bank b1 = new bank();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                b1.deposit(400);
            }
        }, "T1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                b1.withdraw(500);
            }
        }, "T2");


        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                b1.deposit(200);
            }
        }, "T3");

        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                b1.withdraw(600);
            }
        }, "T4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (Exception e) {
            System.out.println("Exception occurred");
        }

        System.out.println("Final Balance = " + b1.balance);
    }
}
