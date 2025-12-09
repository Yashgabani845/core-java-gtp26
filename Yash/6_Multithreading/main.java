class A extends Thread {
    public void run() {
        System.out.println("Thread A running");
    }
}

class B extends Thread {
    public void run() {
        System.out.println("Thread B running");
    }
}

public class main {
    public static void main(String[] args) {
        A t1 = new A();
        B t2 = new B();

        t1.setPriority(10);  // highest
        t2.setPriority(1);   // lowest

        t1.start();
        t2.start();
    }
}
