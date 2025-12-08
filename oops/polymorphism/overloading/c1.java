package oops.polymorphism.overloading;

public class c1 {
    void print(int i){
        System.out.println(i);
    }

    void print(int i,int j){
        System.out.println(i + " "+ j);
    }

    public static void main(String[] args) {
        c1 c = new c1();
        c.print(3);
        c.print(3,4);
    }
}
