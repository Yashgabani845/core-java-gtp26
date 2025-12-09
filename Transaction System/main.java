import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class main {
    public static void main(String[] args) {
        Account a = new Account("Yash");
        //simple multi threading
        WithDrawThread t1 = new WithDrawThread(a,700);
        WithDrawThread t2 = new WithDrawThread(a,700);
        WithDrawThread t3 = new WithDrawThread(a,100);
        DepositThread t4 = new DepositThread(a,500);
        DepositThread t5 = new DepositThread(a,1000);
        DepositThread t6 = new DepositThread(a,100);

        t1.start();
        t2.start();
        t4.start();
    }
}


class Account {
    // boolean success = false;   // removed, must not be shared between threads

    //   volatile int total_balance = 1000;
    AtomicInteger total_balance = new AtomicInteger(1000);
    String name;

    public Account(String name) {
        this.name = name;
    }

    void withdrawn(int amount) {
        boolean success = false; // <-- moved here, thread-local

//        if (total_balance >= amount) {
//            System.out.println("Withdrawing amoutn rs:" + amount);
//            total_balance = total_balance - amount;

        while (!success) {
            int current = total_balance.get();
            if (current >= amount) {

                // CAS only, do NOT subtract twice
                success = total_balance.compareAndSet(current, current - amount);

                if (success) {
                    System.out.println("Balance left " + total_balance);
                }

//            try {
//                Thread.sleep(1000);
//            }
//            catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            } else {
                System.out.println("Insufficient Balance" + total_balance);
//            try {
//                Thread.sleep(1000);
//            }
//            catch (InterruptedException e) {
//                e.printStackTrace();
//            }
                return;  // <-- important: stop when insufficient
            }
        }
    }

    void deposite(int amount) {
        System.out.println("Amount Added " + amount);
//        total_balance = total_balance + amount;
        total_balance.addAndGet(amount);
        System.out.println("Balance = " + total_balance);
//        try {
//            Thread.sleep(1000);
//        }
//        catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}


class WithDrawThread extends Thread {
    Account a;
    int amount;

    WithDrawThread(Account a, int amount) {
        this.a = a;
        this.amount = amount;
    }

    public void run() {
        a.withdrawn(amount);
    }
}

class DepositThread extends Thread {
    Account a;
    int amount;

    DepositThread(Account a, int amount) {
        this.a = a;
        this.amount = amount;
    }

    public void run() {
        a.deposite(amount);
    }
}
