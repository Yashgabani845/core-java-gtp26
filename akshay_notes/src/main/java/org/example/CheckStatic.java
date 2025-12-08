package org.example;

public class CheckStatic {

    void call(){
        Person.show();
    }


    public static void main(String[] args) {
        CheckStatic obj = new CheckStatic();
        obj.call();
    }
}

class Person{
    static void show(){
        System.out.println("calling show()...");
    }
}