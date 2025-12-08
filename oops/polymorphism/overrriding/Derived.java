package oops.polymorphism.overrriding;

import java.util.Base64;

class base{
    void print(){
        System.out.println("from base");
    }
}
public class Derived extends base {

    void print(){
        System.out.println("from derived");
    }
    public static void main(String[] args) {
        Derived d = new Derived();
        d.print();

        base b = new Derived();     // upcasting
        b.print();

        base b1 = new base();
        b1.print();

        // Derived d1 = new base();    // Direct Downcasting not allowed

        Derived d1 = (Derived)b;   // after upcasting do downcasting
        d1.print();
    }
}
