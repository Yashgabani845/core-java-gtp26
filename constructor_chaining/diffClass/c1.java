package constructor_chaining.diffClass;

class c2{
    c2(){
        System.out.println("from c2");
    }
}
public class c1 extends c2{
    c1(){
        super();
        System.out.println("from c1");
    }

    public static void main(String[] args) {
        c1 c = new c1();
    }
}
