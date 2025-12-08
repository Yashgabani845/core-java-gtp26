package oops.inheritance;


interface i1 {
    void print();
}

interface i2 {
    void print();
}

// multiple inheritance
class b implements i1,i2{
    public void print(){
        System.out.println("from b");
    }
}

// single
class b1 extends b{
    void show(){
        System.out.println("from b1");
    }
}

class b2 extends b{
    void show(){
        System.out.println("from b2");
    }
}

// multilevel
public class c extends b1{

    void printmain(){
        System.out.println("from c");
    }
    public static void main(String[] args) {
        c obj = new c();
        obj.printmain();
        obj.show();
        obj.print();

    }
}
