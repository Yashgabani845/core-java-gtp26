package oops.polymorphism.overrriding;

import java.util.Base64;

class base{
    void print(){
        System.out.println("from base");
    }

    private void show(){
        System.out.println("show from base");
    }
}
public class Derived extends base {

    void print(){
        System.out.println("from derived");
    }

    void show(){
        System.out.println("show from derived");
    }
    public static void main(String[] args) {
        Derived d = new Derived();
        d.print();
        d.show();

        base b = new Derived();     // upcasting
        b.print();
        // b.show(); // this won't work bcz show is not overridden

        base b1 = new base();
        b1.print();

        // Derived d1 = new base();    // Direct Downcasting not allowed

        Derived d1 = (Derived)b;   // after upcasting do downcasting
        d1.print();
    }
}
