package enums;

import java.util.Optional;

enum Status{
    STARTED{
        public void print(){
            System.out.println(this + " phase");
        }

    }, PENDING{
        public void print(){
            System.out.println(this + " phase");
        }
    }, PAUSED{
        public void print(){
            System.out.println(this + " phase");
        }

    }, STOPPED{
        public void print(){
            System.out.println(this + " phase");
        }

    };

    private Status(){
        System.out.println("Constructor called for: "+ this);
    }

    public void display(){
        System.out.println("Status is : "+this);
    }

    private int balance = 1000;

    synchronized void deposit(int amount){
        balance  = balance + amount;
        System.out.println("deposit done " + balance);

    }

    synchronized void withdraw(int amount){
        if(balance-amount>=0){
            balance-=amount;
            System.out.println("withdrawn " + balance);

        }else{
            System.out.println("can't be withdrawn " + balance);
        }
    }

    // if any abstract method is present in enum then constants must have to implement that method
    public abstract void print();
}
public class c {
    public static void main(String[] args) {
        // can't create enum object using new object for constants already created when class loaded
        // for the first time, fixed object


        // when first time class loading happens it call constructor for all constants why ??
        // Because Java creates all enum constants eagerly during class initialization and
        // Enums cannot create constants lazily.

        Status s = Status.STARTED;
//        s.display();
        s.print();

        Optional<String> name = Optional.of("Apeksha");
        System.out.println(name.orElse("No name"));

        Optional<String> name1 = Optional.ofNullable(null);
        System.out.println(name1.orElse("No name"));

        Thread t1 = new Thread(()->{
            for(int i=0;i<20;i++)
                s.deposit(100);
        });

        Thread t2 = new Thread(()->{
            for(int i=0;i<20;i++)
                s.withdraw(300);
        });

        t1.start();
        t2.start();

        try {
            t1.join();
        }catch (InterruptedException e){
            System.out.println("Exception occurred");
        }
        try {
            t2.join();
        }catch (InterruptedException e){
            System.out.println("Exception occurred");
        }

    }
}
