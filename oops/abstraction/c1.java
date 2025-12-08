package oops.abstraction;

interface i1{
    int a = 10;

    default void print(){
        System.out.println("default method");
        display();
        display(1);
    }

    private void display(int i){
        System.out.println("private method");
    }

    private static void display(){
        System.out.println("private static method");
    }

    static void show(){
        display();
        System.out.println("static method");
    }

}

public class c1 implements i1{
    public static void main(String[] args) {
        i1 obj = new c1();
        obj.print();
        i1.show();
        System.out.println(i1.a);

    }
}
