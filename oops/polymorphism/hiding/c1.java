package oops.polymorphism.hiding;

class c{
    static void print(){
        System.out.println("from c");
    }
}
public class c1 extends c{
    static void print(){
        System.out.println("from c1");
    }

    public static void main(String[] args) {

        c obj1 = new c1();
        obj1.print();

        c.print();

        c1.print();
    }

}
